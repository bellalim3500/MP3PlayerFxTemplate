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
        player.progressProperty().addListener((obs, oldValue, newValue) -> updateTimeLabel());
    }

    public void updateTimeLabel() {
        if (player.getCurrentTrack() == null)
            return;

        double progress = player.progressProperty().get();

        long totalMs = player.getCurrentTrack().getLength() ; // korrekt!
        long currentMs = (long) (progress * totalMs);

        int minutes = (int) (currentMs / 1000 / 60);
        int seconds = (int) ((currentMs / 1000) % 60);

        root.getTimeLabel().setText( String.format("%02d:%02d", minutes, seconds));
    }

}
