package de.hsrm.mi.enia.mp3player.presentation.views;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.business.Track;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ControlPaneController;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.CoverViewPane;
import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;
public class PlayerViewController extends BaseController <PlayerView> {

    private ControlPaneController controlPaneController;
    private MP3Player player;
    

    public PlayerViewController(PlayerView root, MP3Player player){
        this.root =root;
        this.player=player;
        

        controlPaneController = new ControlPaneController(root.getControlPane(), player);
  
        
    }


    @Override
    public void initalize() {
        controlPaneController.initalize();

        player.getCurrentTrackProperty().addListener(new ChangeListener<Track>() {
           
            @Override
            public void changed(ObservableValue<? extends Track> observable, Track oldValue, Track newValue) {
                updateView(newValue);
            }

            
        });


        if(player.getCurrentTrack() != null){

            updateView(player.getCurrentTrack());

        }
    }
private void updateView(Track track){
    if (track==null) {
        return;
    }

    root.getCoverViewPane().coverView.setImage(track.getAlbumImage());
    root.getSongInfo().update(track);

}
  
}
