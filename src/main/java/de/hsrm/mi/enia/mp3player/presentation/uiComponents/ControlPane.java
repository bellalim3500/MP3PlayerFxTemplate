package de.hsrm.mi.enia.mp3player.presentation.uiComponents;


import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControlPane extends VBox {


    ButtonPane buttonPane;
    ProgressPane progressPane;


    public ControlPane() {

        this.setSpacing(12);
        this.setAlignment(Pos.CENTER);
        setFillWidth(true);
 
        buttonPane = new ButtonPane();
        progressPane = new ProgressPane();

        this.getChildren().addAll(progressPane, buttonPane);
       

    }

    public ButtonPane getButtonPane() {
        return buttonPane;
    }

    public ProgressPane getProgressPane() {
        return progressPane;
    }

}
