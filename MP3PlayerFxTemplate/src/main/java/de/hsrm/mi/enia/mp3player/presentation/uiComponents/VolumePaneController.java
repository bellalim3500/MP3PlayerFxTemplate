package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class VolumePaneController extends BaseController<VolumePane> {

    private MP3Player player;

    public VolumePaneController(VolumePane view){
        this.root=view;
    }

    public void setPlayer(MP3Player player){
        this.player =player;
    }



    @Override
    public void initalize() {
        root.getVolumeSlider().valueProperty().addListener(
            new ChangeListener<Number>() {
                public void changed(
                    ObservableValue<? extends Number>oV,
                    Number oldValue,
                    Number newValue){
                        if (player != null) {
                        player.volume(newValue.floatValue());
                        }
                    }
                }
                );
                
            };
        
    }
    

