package de.hsrm.mi.enia.mp3player.presentation.views;

import de.hsrm.mi.enia.mp3player.business.Track;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class PlaylistView extends BorderPane {
    private Label titleLabel;
    private ListView<Track> playListView;

    public PlaylistView() {
        getStyleClass().add("playlist-view");
        titleLabel = new Label();

        playListView = new ListView<>();

        this.setTop(titleLabel);
        this.setCenter(playListView);

    }

    public Label getTitleLabel() {
        return titleLabel;
    }

    public ListView<Track> getPlaylistView() {
        return playListView;
    }

}
