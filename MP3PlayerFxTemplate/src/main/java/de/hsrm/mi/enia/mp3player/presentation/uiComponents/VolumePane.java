package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import javafx.scene.control.Slider;

import javafx.scene.layout.HBox;

import javafx.scene.layout.AnchorPane;

public class VolumePane extends AnchorPane {

    private HBox view;
    private Slider volumeSlider;

    public VolumePane() {
        view = new HBox();
        volumeSlider = new Slider();
        volumeSlider.setId("volumeSlider");

        view.getChildren().addAll(
                volumeSlider);

        this.getChildren().add(view);


  
    }

      public Slider getVolumeSlider() {
        return volumeSlider;
    }

}