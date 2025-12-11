package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.Track;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class SongTile extends ListCell<Track> {

    HBox tile;
    TextPane songInfo;
    CoverViewPane cover;

    public SongTile() {
        tile = new HBox(10);
        tile.setAlignment(Pos.CENTER_LEFT);

        tile.getStyleClass().add("song-tile");
        songInfo = new TextPane();
        songInfo.setAlignment(Pos.CENTER_LEFT);

        cover = new CoverViewPane();
        cover.setMinSize(60, 60);
        cover.setPrefSize(60, 60);
        cover.setMaxSize(60, 60);

        tile.getChildren().addAll(cover, songInfo);

    }

    @Override
    public void updateItem(Track track, boolean isEmpty) {

        super.updateItem(track, isEmpty);
        if (track != null && !isEmpty) {
            songInfo.update(track);
            cover.coverView.setImage(track.getCoverImage());

            setGraphic(tile);
        } else {
            setGraphic(null);
        }

    }

}
