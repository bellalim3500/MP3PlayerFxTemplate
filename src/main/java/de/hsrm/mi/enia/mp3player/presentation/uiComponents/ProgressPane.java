package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ProgressPane extends HBox {

    private ProgressBar progressBar;
    private Label time;

    public ProgressPane() {
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);

        time = new Label("00:00");

        progressBar = new ProgressBar();
        progressBar.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(progressBar, Priority.ALWAYS);
        this.getChildren().addAll(progressBar, time);

    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public Label getTimeLabel() {
        return time;
    }

}
