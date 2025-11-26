package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ButtonTextPane extends AnchorPane {
    HBox view;
    Text text;
    Button backButton;
    

    public ButtonTextPane (Text text){
        view= new HBox();
        this.text = text;
        backButton=new Button("Zurück");

        view.getChildren().addAll(backButton, text);
        this.getChildren().add(view);
    }
    
}
