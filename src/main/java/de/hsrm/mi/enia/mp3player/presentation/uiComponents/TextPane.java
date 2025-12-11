package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.Track;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TextPane extends VBox {

    public Text artist;
    public Text title;
    public Text album;

    public TextPane() {
        super(2); // kleiner vertikaler Abstand
        setAlignment(Pos.CENTER); // Text mittig

        artist = new Text();
        title = new Text();
        album = new Text();

             title.getStyleClass().add("song-title");
        artist.getStyleClass().add("song-artist");
        album.getStyleClass().add("song-album");

        getChildren().addAll(title, artist, album);
    }

    public void update(Track track) {
        if (track != null) {
            title.setText(track.getTitle() != null ? track.getTitle() : "");
            artist.setText(track.getInterpret() != null ? track.getInterpret() : "");
            album.setText(track.getAlbumTitle() != null ? track.getAlbumTitle() : "");
        } else {
            title.setText("");
            artist.setText("");
            album.setText("");
        }
    }
}
