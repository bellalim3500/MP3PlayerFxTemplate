package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.Playlist;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;
import de.hsrm.mi.enia.mp3player.presentation.views.DashboardView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlayerView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlaylistView;
import javafx.scene.layout.Pane;

public class NavToolbarController extends BaseController<NavToolbar> {

    private DashboardView homeView;
    private PlayerView playerView;
    private PlaylistView playlistView;

    public NavToolbarController(NavToolbar bar, DashboardView homeView, PlayerView playerView, PlaylistView playlistViews){
        this.root=bar;
        this.homeView =homeView;
        this.playerView=playerView;
        this.playlistView=playlistViews;

    
    }

    @Override
    public void initalize() {

        setActiveView(playerView);
       
        root.getHomeButton().setOnAction(e -> setActiveView(homeView));
        root.getPlayerButton().setOnAction(e-> setActiveView(playerView));
        root.getPlaylistButton().setOnAction(e -> setActiveView(playlistView));


    }

    private void setActiveView(Pane active){
        homeView.setVisible(false);
        playerView.setVisible(false);
        playlistView.setVisible(false);

        active.setVisible(true);
        
    }
    
}
