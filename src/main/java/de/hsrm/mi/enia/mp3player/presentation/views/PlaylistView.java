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
        getStyleClass().add("playlist-view");
        titleLabel = new Label();

        playListView = new  ListView<>();

        controlPane = new ControlPane();
        this.setTop(titleLabel);
        this.setCenter(playListView);

      
    }



    public Label getTitleLabel() {
        return titleLabel;
    }

    public ListView<Track> getPlaylistView() {
        return playListView;
    }

    public ControlPane getControlPane() {
		return controlPane;
	}


    
}
