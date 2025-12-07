package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import javafx.animation.AnimationTimer;

public class AnimationMonitor {
     private final MP3Player player;
    private AnimationTimer timer;

    public AnimationMonitor(MP3Player player) {
        this.player = player;

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };

        timer.start();
    }

    private void update() {
        if (player.getAudioPlayer() == null) return;
        if (player.getCurrentTrack() == null) return;

        double pos = player.getAudioPlayer().position();
        double total = player.getCurrentTrack().getLength();

        if (total > 0) {
            player.progressProperty().set(pos / total);
        }
    }
}

    

