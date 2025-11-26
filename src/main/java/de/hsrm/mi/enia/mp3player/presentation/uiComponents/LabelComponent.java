package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class LabelComponent extends AnchorPane{
 

    TextFlow text;
    Text label1;
    Text label2;

    public LabelComponent(Text label1, Text label2){
        this.label1=label1;
        this.label2= label2;
       
        text = new TextFlow();

        label1.setFont(Font.font(null, FontWeight.BOLD,14));
        label2.setFont(Font.font(null, FontPosture.ITALIC, 14));

        text.getChildren().addAll(label1,label2);
    }

}
