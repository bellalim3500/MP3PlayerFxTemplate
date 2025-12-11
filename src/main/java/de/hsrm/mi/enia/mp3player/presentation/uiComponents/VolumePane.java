package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class VolumePane extends HBox {

    private Slider volumeSlider;

    public VolumePane() {
        volumeSlider = new Slider(0,100,50);


        getChildren().add(volumeSlider);
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }
}
