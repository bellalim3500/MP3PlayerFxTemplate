package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ButtonPane extends AnchorPane {

    HBox view;

    Button repeatButton;
    Button previousButton;
    Button pauseButton;
    Button playButton;
    Button skipButton;
    Button shuffleButton;

    public ButtonPane() {
        view= new HBox();
        repeatButton = new Button("repeat");
        repeatButton.setId("repeatButton");
        shuffleButton = new Button("shuffle");
        shuffleButton.setId("shuffleButton");
        previousButton = new Button("rewind");
        previousButton.setId("previousButton");
        playButton = new Button("play");
        playButton.setId("playButton");
        skipButton = new Button("skip");
        skipButton.setId("skipButton");
        playButton.getStyleClass().addAll("buttonPane");
        pauseButton = new Button("pause");
        pauseButton.setId("pauseButton");

        view.getChildren().addAll(
            repeatButton,
            previousButton,
            playButton,
            pauseButton,
            skipButton,
            shuffleButton
            );

            this.getChildren().add(view);
            
           


    }

    public Button getRepeatButton() {
        return repeatButton;
    }

    public Button getPreviousButton() {
        return previousButton;
    }

    public Button getPauseButton() {
        return pauseButton;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public Button getSkipButton() {
        return skipButton;
    }

    public Button getShuffleButton() {
        return shuffleButton;
    }
}