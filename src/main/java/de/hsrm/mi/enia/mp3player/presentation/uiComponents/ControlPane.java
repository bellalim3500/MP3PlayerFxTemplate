package de.hsrm.mi.enia.mp3player.presentation.uiComponents;


import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControlPane extends AnchorPane {
    VBox view;
    ButtonPane buttonPane;
    TextPane songInfo;
    ProgressPane progressPane;
    VolumePane volumePane;

    public ControlPane() {

        view = new VBox();
        view.setSpacing(15);          // Abstand zwischen ProgressBar, Text & Buttons
view.setAlignment(Pos.CENTER);

        buttonPane = new ButtonPane();
        songInfo = new TextPane();
        progressPane = new ProgressPane();
        volumePane = new VolumePane();

        view.getChildren().addAll(progressPane, songInfo, buttonPane, volumePane);

        this.getChildren().add(view);

    }

    public ButtonPane getButtonPane() {
        return buttonPane;
    }

    public ProgressPane getProgressPane() {
        return progressPane;
    }

    public VolumePane getVolumePane() {
        return volumePane;
    }

    public TextPane getSongInfo() {
        return songInfo;
    }   

    

}
