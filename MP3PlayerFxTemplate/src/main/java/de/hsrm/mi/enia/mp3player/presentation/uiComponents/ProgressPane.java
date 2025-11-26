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

        time = new Label("xx:xx");

        progressBar = new ProgressBar();

        view.getChildren().addAll(progressBar, time);

        this.getChildren().add(view);
    }

}
