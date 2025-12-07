package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;

public class ButtonPaneController extends BaseController<ButtonPane> {

    private MP3Player player;

    public ButtonPaneController(ButtonPane view, MP3Player player) {
        this.root = view;
        this.player = player;

        initialize();
    }

    @Override
    public void initialize() {

        root.getPreviousButton().setOnAction(e -> player.previous());
        root.getPlayPauseButton().setOnAction(e -> {
            if (player.getCurrentTrack() == null) {
                player.playTrack(0);
                root.getPlayPauseButton().setText("Pause");
                return;
            }
             if (!player.getAudioPlayer().isPlaying()
                    && player.getAudioPlayer().position() >= player.getAudioPlayer().length()) {

                player.skip();
                root.getPlayPauseButton().setText("Pause");
                return;
            }

            if (player.isPlaying()) {
                player.pause();
                root.getPlayPauseButton().setText("Play");
            } else {
                player.resume();
                root.getPlayPauseButton().setText("Pause");
            }
        });

        player.getCurrentTrackProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                root.getPlayPauseButton().setText("Pause");
            }
        });
        root.getSkipButton().setOnAction(e -> player.skip());

        root.getShuffleButton().setOnAction(e -> player.shuffle());

    }

}
