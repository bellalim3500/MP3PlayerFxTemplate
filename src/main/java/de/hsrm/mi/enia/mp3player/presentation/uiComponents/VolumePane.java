package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class VolumePane extends HBox {

   
    private Slider volumeSlider;

    public VolumePane() {
      
        volumeSlider = new Slider();
        volumeSlider.setPrefWidth(150);
        volumeSlider.setMaxWidth(250);
        volumeSlider.setMinWidth(80);

        this.getChildren().addAll(
                volumeSlider);
  
    }

      public Slider getVolumeSlider() {
        return volumeSlider;
    }

}