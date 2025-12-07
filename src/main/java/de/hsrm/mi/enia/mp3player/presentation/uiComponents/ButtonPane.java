package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

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
        view= new HBox();
      
        shuffleButton = new Button("shuffle");
        shuffleButton.setId("shuffleButton");
        previousButton = new Button("previous");
        previousButton.setId("previousButton");
        playPauseButton = new Button("Play");
        playPauseButton.setId("playPauseButton");
        skipButton = new Button("skip");
        skipButton.setId("skipButton");
        playPauseButton.getStyleClass().addAll("buttonPane");
       
        view.getChildren().addAll(
  
            previousButton,
            playPauseButton,
        
            skipButton,
            shuffleButton
            );

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