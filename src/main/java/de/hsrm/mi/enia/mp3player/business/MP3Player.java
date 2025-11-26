package de.hsrm.mi.enia.mp3player.business;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;

import java.io.File;
import java.util.Collections;

public class MP3Player {
    private int currentTrack = -1;
    private SimpleMinim minim;
    private SimpleAudioPlayer audioPlayer;
    private Playlist aktPlaylist;
    private boolean repeat, shuffle;

    public MP3Player() {
        minim = new SimpleMinim(true);
    }

    public void play(String fileName) {
         File file = new File(fileName);
    System.out.println("Vollständiger Pfad: " + file.getAbsolutePath());
    System.out.println("Datei existiert: " + file.exists());
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        if (audioPlayer != null) {
            audioPlayer.pause();
            audioPlayer.skip(audioPlayer.length());
            audioPlayer = null;
        }
        if (audioPlayer == null) {
            audioPlayer = minim.loadMP3File(fileName);
            audioPlayer.play();
        }
    }

    public void playTrack(int trackIndex) {

        currentTrack = trackIndex;
        if (aktPlaylist == null || trackIndex < 0 || trackIndex >= aktPlaylist.numberOfTracks()) {
          System.err.print(" Invalid trackIndex.");
            return;
        }
        Track track = aktPlaylist.getTrack(trackIndex);

        play("music" + File.separator + track.getSoundFile());

    }

    public void skip() {
        if (aktPlaylist == null || aktPlaylist.numberOfTracks() == 0) {
            System.err.print(" Invalid Playlist. Skip not possible");
            return;
        }
        int nextIndex = currentTrack + 1;

        if (nextIndex >= aktPlaylist.numberOfTracks()) {
            nextIndex = 0;
        }

        playTrack(nextIndex);
    }

    public void previous() {
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

    public void play() {
        if (audioPlayer != null && !audioPlayer.isPlaying()) {
            audioPlayer.play();
        }
    }

    public void pause() {
        if (audioPlayer != null && audioPlayer.isPlaying()) {
            audioPlayer.pause();
        }
    }

    public void playPlaylist() {
        if (shuffle) {
            Collections.shuffle(aktPlaylist.getList());
        }

        for (Track track : aktPlaylist.getList()) {
            do {
                play("songs/" + track.getSoundFile());
            } while (shuffle);
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

        }

    }

    public Track getCurrentTrack() {
        if (aktPlaylist != null && currentTrack >= 0 && currentTrack < aktPlaylist.numberOfTracks()) {
            return aktPlaylist.getTrack(currentTrack);
        }
        return null;

    }

    public void setAktPlaylist(Playlist aktPlaylist) {
        this.aktPlaylist = aktPlaylist;
    }

    public Playlist getAktPlaylist() {
        return aktPlaylist;
    }

    public void shuffle() {
        if (shuffle == true) {
            shuffle = false;
        } else {
            shuffle = true;
        }
    }

    public void repeat() {

        // Logik

        if (audioPlayer.isLooping()) {
            audioPlayer.play();
            repeat = false;
        } else {
            audioPlayer.loop();
            repeat = true;
        }
    }

    public void rewind() {
        audioPlayer.rewind();
    }

}
