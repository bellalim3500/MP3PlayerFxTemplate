package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;
import de.hsrm.mi.enia.mp3player.presentation.views.PlayerView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlaylistView;
import javafx.scene.layout.Pane;

public class NavToolbarController extends BaseController<NavToolbar> {


    private PlayerView playerView;
    private PlaylistView playlistView;

    public NavToolbarController(NavToolbar bar, PlayerView playerView, PlaylistView playlistViews){
        this.root=bar;
        this.playerView=playerView;
        this.playlistView=playlistViews;

        initialize();

    
    }

    @Override
    public void initialize() {

        setActiveView(playlistView);
       
       
        root.getPlayerButton().setOnAction(e-> setActiveView(playerView));
        root.getPlaylistButton().setOnAction(e -> setActiveView(playlistView));


    }

    private void setActiveView(Pane active){
        
        playerView.setVisible(false);
        playlistView.setVisible(false);

        active.setVisible(true);
        
    }
    
}
