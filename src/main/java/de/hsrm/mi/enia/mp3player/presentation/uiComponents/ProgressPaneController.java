package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;

public class ProgressPaneController extends BaseController<ProgressPane> {

    MP3Player player;

    public ProgressPaneController(ProgressPane root, MP3Player player) {
        this.root = root;
        this.player = player;
        initialize();
    }

    @Override
    public void initialize() {
        root.getProgressBar().progressProperty().bind(player.progressProperty());
        root.getTimeLabel().textProperty().bind(player.timeProperty());
    }

  
}
