package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;



public class CoverViewPane extends AnchorPane{



    // private Image image;
    public ImageView coverView;
  
    private Image DEFAULT_IMAGE;
    
    // private Button addToPlaylist;

    public CoverViewPane(){


        DEFAULT_IMAGE = new Image(getClass().getResource("/default-image-icon-vector-missing-picture-page-website-design-mobile-app-no-photo-available-236105299.jpg").toExternalForm());
        coverView= new ImageView();
        coverView.setPreserveRatio(true);
        coverView.fitWidthProperty().bind(widthProperty());
        coverView.setFitHeight(200);
        coverView.setImage(DEFAULT_IMAGE);
        
        this.getChildren().addAll(coverView);
    


    }


    
}
