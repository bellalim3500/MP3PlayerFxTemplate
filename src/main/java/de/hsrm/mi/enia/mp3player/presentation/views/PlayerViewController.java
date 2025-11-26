package de.hsrm.mi.enia.mp3player.presentation.views;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ControlPaneController;

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
    }

  
}
