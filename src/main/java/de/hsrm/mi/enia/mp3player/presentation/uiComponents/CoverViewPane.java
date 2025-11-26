package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import eia.ui.ImageViewPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class CoverViewPane extends StackPane{

    // private Image image;
    public ImageView coverView;
  
    private Image DEFAULT_IMAGE;
    
    // private Button addToPlaylist;

    public CoverViewPane(){


        DEFAULT_IMAGE = new Image(getClass().getResource("/default-image-icon-vector-missing-picture-page-website-design-mobile-app-no-photo-available-236105299.jpg").toExternalForm());
        coverView= new ImageView();
        coverView.setPreserveRatio(true);
        coverView.setFitWidth(200);
        coverView.setFitHeight(200);
        coverView.setImage(DEFAULT_IMAGE);

        // addToPlaylist = new Button("Add");
        // addToPlaylist.setId("addToPlaylistButton");




       
        this.getChildren().addAll(coverView);
        //this.setAlignment(addToPlaylist, Pos.TOP_RIGHT);

    }


    
}
