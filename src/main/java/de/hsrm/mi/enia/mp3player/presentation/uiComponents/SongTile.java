package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.Track;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class SongTile extends ListCell<Track> {

    HBox tile;
    TextPane songInfo;
    CoverViewPane cover;
    
    public SongTile(){
        tile=new HBox();
        songInfo=new TextPane();

        cover= new CoverViewPane();
        tile.getChildren().addAll(cover, songInfo);



    }

    @Override
    public void updateItem(Track track, boolean isEmpty){

        super.updateItem(track, isEmpty);
        if(track!=null && !isEmpty){
            songInfo.update(track);
            cover.coverView.setImage(track.getAlbumImage());

            setGraphic(tile);
        } else {
            setGraphic(null);
        }

    }
    
    
}
