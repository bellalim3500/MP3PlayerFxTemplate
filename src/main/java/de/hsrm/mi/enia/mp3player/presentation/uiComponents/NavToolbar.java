package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.layout.HBox;


public class NavToolbar extends HBox {

   
    private Button player;
    private Button playlist;

    public NavToolbar(){
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);

        this.getStyleClass().add("nav-bar");
        
        player= new Button ("Player");
        playlist = new Button("Playlist");


        this.getChildren().addAll(player,playlist);

    }

  

    public Button getPlayerButton() {
        return player;
    }

    public Button getPlaylistButton() {
        return playlist;
    }

    

    
    
    
}
