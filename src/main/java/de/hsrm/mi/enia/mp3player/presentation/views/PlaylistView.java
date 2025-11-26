package de.hsrm.mi.enia.mp3player.presentation.views;
import de.hsrm.mi.enia.mp3player.business.Track;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ControlPane;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;


public class PlaylistView extends BorderPane {
    private Label titleLabel;
    private ListView<Track> playListView;
    private ControlPane controlPane;

    public PlaylistView() {
        // titleLabel = new Label(playlist.getTitle());

        //ListView
        playListView = new  ListView<>();

        controlPane = new ControlPane();

        // Titel oben
        this.setTop(titleLabel);

        // Playlist in der Mitte
        this.setCenter(playListView);

        // ControlPane unten
        this.setBottom(controlPane);
    }



    public Label getTitleLabel() {
        return titleLabel;
    }

    public ListView<Track> getPlaylistView() {
        return playListView;
    }

    
}
