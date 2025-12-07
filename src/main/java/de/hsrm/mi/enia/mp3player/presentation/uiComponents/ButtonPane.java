package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ButtonPane extends AnchorPane {

    HBox view;

    Button previousButton;
    Button playPauseButton;

    Button skipButton;
    Button shuffleButton;

    public ButtonPane() {
        view = new HBox(20);            // 20px Abstand zwischen Buttons
view.setAlignment(Pos.CENTER);

        shuffleButton = new Button("🔀");
        previousButton = new Button("⏮");
        playPauseButton = new Button("▶"); // Start immer Play
        skipButton = new Button("⏭");

        shuffleButton.setId("shuffleButton");

        previousButton.setId("previousButton");

        playPauseButton.setId("playPauseButton");

        skipButton.setId("skipButton");

        view.getChildren().addAll(

                previousButton,
                playPauseButton,

                skipButton,
                shuffleButton);

        this.getChildren().add(view);

    }

    public Button getPreviousButton() {
        return previousButton;
    }

    public Button getPlayPauseButton() {
        return playPauseButton;
    }

    public Button getSkipButton() {
        return skipButton;
    }

    public Button getShuffleButton() {
        return shuffleButton;
    }
}