package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;

public class ControlPaneController extends BaseController<ControlPane> {

    private ButtonPaneController buttonPaneController;
    private MP3Player player;
    private ProgressPaneController progressPaneController;

    public ControlPaneController(ControlPane root, MP3Player player) {
        this.root = root;
        this.player = player;

        buttonPaneController = new ButtonPaneController(root.getButtonPane(), player);
        progressPaneController = new ProgressPaneController(root.getProgressPane(), player);

        initialize();
    }

    @Override
    public void initialize() {

    }

}
