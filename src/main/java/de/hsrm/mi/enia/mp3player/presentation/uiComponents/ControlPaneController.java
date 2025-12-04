package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;

public class ControlPaneController extends BaseController <ControlPane> {

    private ButtonPaneController buttonPaneController;
    private VolumePaneController volumePaneController;
    private MP3Player player;


    public ControlPaneController(ControlPane root, MP3Player player){
        this.root=root;
        this.player =player;
        

        buttonPaneController = new ButtonPaneController(root.getButtonPane(),player);
  



        volumePaneController = new VolumePaneController(root.getVolumePane());
        volumePaneController.setPlayer(player);
    }



    @Override
    public void initalize() {
        buttonPaneController.initalize();
        volumePaneController.initalize();
    }
    
}
