package de.hsrm.mi.enia.mp3player.presentation.views;

import java.util.List;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.business.Playlist;
import de.hsrm.mi.enia.mp3player.business.PlaylistManager;
import de.hsrm.mi.enia.mp3player.business.Track;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.SongTile;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.SongTileController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class PlaylistViewController extends BaseController<PlaylistView>{

    MP3Player player;
    PlaylistManager manager;
    ListView<Track> playlistList;
    SongTileController songTileController;
    
    

    public PlaylistViewController(PlaylistView playlistView, MP3Player player, PlaylistManager manager){
        root = playlistView;
        this.player = player;
        this.manager = manager;
     
       

        Playlist playlist = player.getAktPlaylist();
        playlistList = root.getPlaylistView();

        playlistList.setCellFactory(param -> new SongTile());    


        //umformen in observable 

        ObservableList<Track> items = FXCollections.observableArrayList(playlist.getList());
        playlistList.setItems(items);
         songTileController = new SongTileController(playlistList.getSelectionModel().getSelectedItem());




    } 



    @Override
    public void initalize() {

     
        
        
    }

     
}
    

