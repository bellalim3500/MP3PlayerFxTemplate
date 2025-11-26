package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import java.sql.Time;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.business.Track;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;

public class SongTileController extends BaseController<SongTile> {

    private MP3Player player;

    public SongTileController(SongTile tile) {
        this.root = tile;
    }

    public void setPlayer(MP3Player player) {
        this.player = player;
    }

    @Override
    public void initalize() {
        root.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                Track track = root.getItem();

                if (track != null && player != null) {

                    player.play("music/" + track.getSoundFile());
                }

            }
        });
    }

}
