package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ControlPane extends VBox {

    private ButtonPane buttonPane;
    private ProgressPane progressPane;

    public ControlPane() {
        this.setSpacing(12);
        setPadding(new Insets(12,12,12,12));
        setAlignment(Pos.CENTER);
        
            getStyleClass().add("control-pane");

        progressPane = new ProgressPane();
        buttonPane = new ButtonPane();

        getChildren().addAll(progressPane, buttonPane);
    }

    public ButtonPane getButtonPane() {
        return buttonPane;
    }

    public ProgressPane getProgressPane() {
        return progressPane;
    }
}
