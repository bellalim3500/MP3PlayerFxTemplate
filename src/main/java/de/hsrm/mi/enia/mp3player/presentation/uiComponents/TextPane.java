package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.Track;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class TextPane extends AnchorPane{

    public VBox text;
    public Text artist;
    public Text title;
    public Text album;


    public TextPane(){ // optional später die argumente als variablen mitgeben 

        text = new VBox();

        artist = new Text();
        title = new Text();
        album = new Text();

        text.getChildren().addAll(title, artist, album);
        this.getChildren().add(text);



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
