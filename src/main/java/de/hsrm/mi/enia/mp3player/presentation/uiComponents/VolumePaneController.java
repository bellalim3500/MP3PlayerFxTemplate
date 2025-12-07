package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;

public class VolumePaneController extends BaseController<VolumePane> {

    private MP3Player player;

    public VolumePaneController(VolumePane view) {
        this.root = view;

    }

    public void setPlayer(MP3Player player) {
        this.player = player;
    }

    @Override
    public void initialize() {
        root.getVolumeSlider().valueProperty().bindBidirectional(player.getVolumeProperty());
    };

}
