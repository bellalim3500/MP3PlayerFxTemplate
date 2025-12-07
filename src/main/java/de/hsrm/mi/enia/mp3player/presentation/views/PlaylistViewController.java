package de.hsrm.mi.enia.mp3player.presentation.views;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.business.Playlist;
import de.hsrm.mi.enia.mp3player.business.PlaylistManager;
import de.hsrm.mi.enia.mp3player.business.Track;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ControlPaneController;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.SongTile;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.SongTileController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class PlaylistViewController extends BaseController<PlaylistView> {

    MP3Player player;
    PlaylistManager manager;
    ListView<Track> playlistList;
    SongTileController songTileController;
    ControlPaneController controlPaneController;

    public PlaylistViewController(PlaylistView playlistView, MP3Player player, PlaylistManager manager) {
        root = playlistView;
        this.player = player;
        this.manager = manager;
        controlPaneController = new ControlPaneController(root.getControlPane(), player);

        playlistList = root.getPlaylistView();

        playlistList.setCellFactory(param -> {
            SongTile tile = new SongTile();
            songTileController = new SongTileController(tile);
            songTileController.setPlayer(player);
            songTileController.initialize();
            return tile;
        });

        // umformen in observable
        Playlist playlist = player.getAktPlaylist();

        ObservableList<Track> items = FXCollections.observableArrayList(playlist.getList());
        playlistList.setItems(items);

        initialize();

    }

    @Override
    public void initialize() {


    }

}
