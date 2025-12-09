package de.hsrm.mi.enia.mp3player.business;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MP3Player {
    private int currentTrack = -1;
    private SimpleMinim minim;
    private SimpleAudioPlayer audioPlayer;
    private Playlist aktPlaylist;
    private boolean shuffle;
    private Thread progressThread;
    private boolean running;

    private final ObjectProperty<Track> currentTrackProperty = new SimpleObjectProperty<>();
    private final DoubleProperty volumeProperty = new SimpleDoubleProperty(0);
    private final DoubleProperty progressProperty = new SimpleDoubleProperty(0);
    private final StringProperty timeProperty = new SimpleStringProperty("00:00");

    public MP3Player() {
        minim = new SimpleMinim();
        volumeProperty.addListener((obs, oldValue, newValue) -> {
            volume(newValue.floatValue());

        });

    }

    private void startProgressThread() {
        running = true;

        progressThread = new Thread(() -> {
            while (running) {
                try {
                    if (audioPlayer != null && currentTrackProperty.get() != null) {

                        double pos = audioPlayer.position();
                        double total = currentTrackProperty.get().getLength();

                        long currentMs = (long) pos;
                        int minutes = (int) (currentMs / 1000 / 60);
                        int seconds = (int) ((currentMs / 1000) % 60);

                        Platform.runLater(() -> {
                            progressProperty.set(pos / total);
                            timeProperty.set(String.format("%02d:%02d", minutes, seconds));
                        });

                        if (!audioPlayer.isPlaying() && audioPlayer.position() > 200) {
                           Platform.runLater(() -> skip());
                        }

                    }

                    Thread.sleep(200);

                } catch (InterruptedException e) {
                    running = false;
                }
            }
        });

        progressThread.start();
    }

    private void stopProgressThread() {
        running = false;
        if (progressThread != null) {
            progressThread.interrupt();

        }
    }

    public void playFile(String fileName) {

        if (audioPlayer != null) {
            audioPlayer.pause();
            audioPlayer.skip(audioPlayer.length());
            audioPlayer = null;
        }
        audioPlayer = minim.loadMP3File(fileName);

        new Thread(new Runnable() {

            @Override
            public void run() {
                audioPlayer.play();

            }
        }).start();

        stopProgressThread();
        ;
        startProgressThread();

        progressProperty.set(0);
        timeProperty.set("00:00");
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void update() {

    }

    public void play(Track track) {

        if (aktPlaylist == null || track == null) {
            System.err.print(" Invalid track.");
            return;
        }

        currentTrack = aktPlaylist.getList().indexOf(track);
        setCurrentTrack(track);

        if (currentTrack != -1) {
            playFile(track.getSoundFile());
        }

    }

    public SimpleAudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public boolean isPlaying() {
        return audioPlayer.isPlaying();
    }

    public void playTrack(int trackIndex) {

        currentTrack = trackIndex;
        if (aktPlaylist == null || trackIndex < 0 || trackIndex >= aktPlaylist.numberOfTracks()) {
            System.err.print(" Invalid trackIndex.");
            return;
        }
        Track track = aktPlaylist.getTrack(trackIndex);

        play(track);

    }

    public synchronized void skip() {
        if (aktPlaylist == null || aktPlaylist.numberOfTracks() == 0) {
            System.err.print(" Invalid Playlist. Skip not possible");
            return;
        }

        if (shuffle) {
            int next = (int) (Math.random() * aktPlaylist.numberOfTracks());
            playTrack(next);
            return;
        }

        int nextIndex = currentTrack + 1;

        if (nextIndex >= aktPlaylist.numberOfTracks()) {
            nextIndex = 0;
        }

        playTrack(nextIndex);
    }

    public synchronized void previous() {
        if (aktPlaylist == null || aktPlaylist.numberOfTracks() == 0) {
            System.err.print(" Invalid Playlist. Skip not possible");
            return;
        }

        int prevIndex = currentTrack - 1;
        if (prevIndex < 0) {
            prevIndex = aktPlaylist.numberOfTracks() - 1;
        }
        playTrack(prevIndex);
    }

    public void resume() {
        if (audioPlayer != null && !audioPlayer.isPlaying()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    audioPlayer.play();
                }
            }).start();

        }
    }

    public void pause() {
        if (audioPlayer != null && audioPlayer.isPlaying()) {
            audioPlayer.pause();
        }
    }

    public void volume(float value) {

        if (audioPlayer != null) {
            audioPlayer.setGain(value);
        }
    }

    public void mute() {
        if (audioPlayer != null) {
            if (audioPlayer.isMuted()) {
                audioPlayer.unmute();
            } else {
                audioPlayer.mute();
            }
        }
    }

    public void quit() {
        if (audioPlayer != null) {
            audioPlayer.pause();
            audioPlayer.skip(audioPlayer.length());
            audioPlayer = null;
            currentTrack = -1;
            setCurrentTrack(null);

        }

    }

    public ObjectProperty<Track> getCurrentTrackProperty() {
        return currentTrackProperty;
    }

    public Track getCurrentTrack() {
        return currentTrackProperty.get();
    }

  private void setCurrentTrack(Track track) {
    Platform.runLater(() -> currentTrackProperty.set(track));
}
    public DoubleProperty getVolumeProperty() {
        return volumeProperty;

    }

    public DoubleProperty progressProperty() {
        return progressProperty;
    }

    public StringProperty timeProperty() {
        return timeProperty;
    }

    public void setAktPlaylist(Playlist aktPlaylist) {
        this.aktPlaylist = aktPlaylist;
    }

    public Playlist getAktPlaylist() {
        return aktPlaylist;
    }

    public void shuffle() {
        shuffle = !shuffle;
    }

}
