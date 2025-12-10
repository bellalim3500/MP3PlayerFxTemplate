package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;
import de.hsrm.mi.enia.mp3player.presentation.views.PlayerView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlaylistView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class NavToolbarController extends BaseController<NavToolbar> {

    private BorderPane rootPane;
    private PlayerView playerView;
    private PlaylistView playlistView;

    public NavToolbarController(NavToolbar bar, PlayerView playerView, PlaylistView playlistViews, BorderPane root) {
        this.root = bar;
        this.playerView = playerView;
        this.playlistView = playlistViews;
        this.rootPane =root;

        initialize();

    }

    @Override
    public void initialize() {

        setActiveView(playerView);

        root.getPlayerButton().setOnAction(e -> setActiveView(playerView));
        root.getPlaylistButton().setOnAction(e -> setActiveView(playlistView));

    }

    private void setActiveView(Pane active) {

        rootPane.setCenter(active);

    }

}
