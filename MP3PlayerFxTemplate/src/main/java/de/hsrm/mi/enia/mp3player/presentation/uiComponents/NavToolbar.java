package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;

public class NavToolbar extends ToolBar {

    private Button home;
    private Button player;
    private Button playlist;

    public NavToolbar(){
        home =new Button("Home");
        player= new Button ("Player");
        playlist = new Button("Playlist");

        this.getItems().addAll(home,player,playlist);

    }

    public Button getHomeButton() {
        return home;
    }

    public Button getPlayerButton() {
        return player;
    }

    public Button getPlaylistButton() {
        return playlist;
    }

    

    
    
    
}
