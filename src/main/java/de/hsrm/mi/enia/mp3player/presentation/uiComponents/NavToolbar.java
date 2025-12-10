package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;


public class NavToolbar extends ToolBar {

   
    private Button player;
    private Button playlist;

    public NavToolbar(){

    
        player= new Button ("Player");
        playlist = new Button("Playlist");

        this.getItems().addAll(player,playlist);

    }

  

    public Button getPlayerButton() {
        return player;
    }

    public Button getPlaylistButton() {
        return playlist;
    }

    

    
    
    
}
