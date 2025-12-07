package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ProgressPane extends AnchorPane {
    HBox view;
    private ProgressBar progressBar;
    private Label time;

    public ProgressPane() {
        view = new HBox();

        time = new Label("00:00");

        progressBar = new ProgressBar();
        progressBar.setPrefWidth(300);

        view.getChildren().addAll(progressBar, time);

        this.getChildren().add(view);
    }
    
    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public Label getTimeLabel() {
        return time;
    }

}
