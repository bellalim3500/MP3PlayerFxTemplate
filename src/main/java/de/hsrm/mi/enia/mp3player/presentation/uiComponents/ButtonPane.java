package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane extends HBox {

    private Button previousButton;
    private Button playPauseButton;
    private Button skipButton;
    private Button shuffleButton;
    private VolumePane volumePane;

    public ButtonPane() {
        super(15);
        setAlignment(Pos.CENTER); // gesamte Gruppe zentriert

        shuffleButton = new Button("🔀");
        previousButton = new Button("⏮");
        playPauseButton = new Button("▶"); // Start immer Play
        skipButton = new Button("⏭");

        volumePane = new VolumePane();

        getChildren().addAll(
                previousButton,
                playPauseButton,
                skipButton,
                shuffleButton,
                volumePane
        );
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

    public VolumePane getVolumePane() {
        return volumePane;
    }
}
