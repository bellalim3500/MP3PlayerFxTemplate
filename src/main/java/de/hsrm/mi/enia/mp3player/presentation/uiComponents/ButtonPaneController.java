package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonPaneController extends BaseController<ButtonPane> {

    private MP3Player player;

    public ButtonPaneController(ButtonPane view, MP3Player player) {
        this.root = view;
        this.player = player;
    }

    @Override
    public void initalize() {

        root.getRepeatButton().setOnAction(e -> player.repeat());
        root.getPreviousButton().setOnAction(e -> player.previous());
        root.getPlayButton().setOnAction(e -> player.play(player.getCurrentTrack().getSoundFile()));
        root.getSkipButton().setOnAction(e -> player.skip());
        root.getPauseButton().setOnAction(e -> player.pause());
        root.getShuffleButton().setOnAction(e -> player.shuffle());

    }

}
