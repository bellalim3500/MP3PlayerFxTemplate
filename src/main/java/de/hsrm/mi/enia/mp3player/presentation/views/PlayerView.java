package de.hsrm.mi.enia.mp3player.presentation.views;

import de.hsrm.mi.enia.mp3player.presentation.uiComponents.CoverViewPane;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.TextPane;
import javafx.geometry.Pos;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;

public class PlayerView extends BorderPane {

    private CoverViewPane cover;
    private TextPane songInfo;

    private VBox centerBox;

    public PlayerView() {
        getStyleClass().add("player-view");

        cover = new CoverViewPane();
		cover.setMaxWidth(Double.MAX_VALUE);
        
        songInfo = new TextPane();
        songInfo.setMaxWidth(Double.MAX_VALUE);

        centerBox = new VBox(10);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(cover, songInfo);
        

        setCenter(centerBox);


        BorderPane.setAlignment(centerBox, Pos.CENTER);
        
    }

    public CoverViewPane getCoverViewPane() {
        return cover;
    }

    public TextPane getSongInfo() {
        return songInfo;
    }
}
