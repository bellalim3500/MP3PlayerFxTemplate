package de.hsrm.mi.enia.mp3player.presentation.uiComponents;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.presentation.views.BaseController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonPaneController extends BaseController<ButtonPane> {


    private MP3Player player;

    public ButtonPaneController(ButtonPane view) {
        this.root = view;
    }

    public void setPlayer(MP3Player player) {
        this.player = player;
    }

    @Override
    public void initalize(){

       
    
        root.getRepeatButton().setOnAction(e -> player.repeat());
        root.getPreviousButton().setOnAction(e -> player.previous());
        root.getPlayButton().setOnAction(e -> player.play(player.getCurrentTrack().getSoundFile()));
        root.getSkipButton().setOnAction(e -> player.skip());
        root.getPauseButton().setOnAction(e -> player.pause());
        root.getShuffleButton().setOnAction(e -> player.shuffle());


        // repeatButton.addEventHandler(ActionEvent.ACTION, new RepeatHandler());
        // rewindButton.addEventHandler(ActionEvent.ACTION, new RewindHandler());
        // playButton.addEventHandler(ActionEvent.ACTION, new PlayHandler());
        // skipButton.addEventHandler(ActionEvent.ACTION, new SkipHandler());
        // shuffleButton.addEventHandler(ActionEvent.ACTION, new ShuffleHandler());
        // pauseButton.addEventHandler(ActionEvent.ACTION, new RewindHandler());

    }

    // public class PlayHandler implements EventHandler<ActionEvent> {
    //     @Override
    //     public void handle(ActionEvent event) {
    //         player.play();
    //         System.out.println("Is playing");
    //     }
    // }

    // public class RepeatHandler implements EventHandler<ActionEvent> {
    //     @Override
    //     public void handle(ActionEvent event) {

    //         // TODO Logik wenn es an ist??

    //         player.repeat();
    //         System.out.println("Repeat pressed");
    //     }
    // }

    // public class RewindHandler implements EventHandler<ActionEvent> {
    //     @Override
    //     public void handle(ActionEvent event) {
    //         player.rewind();
    //         System.out.println("Is rewinded");
    //     }
    // }

    // public class PauseHandler implements EventHandler<ActionEvent> {
    //     @Override
    //     public void handle(ActionEvent event) {
    //         player.pause();
    //         System.out.println("paused");
    //     }
    // }

    // public class SkipHandler implements EventHandler<ActionEvent> {
    //     @Override
    //     public void handle(ActionEvent event) {
    //         player.skip();
    //         System.out.println("Is skipped");
    //     }
    // }

    // public class ShuffleHandler implements EventHandler<ActionEvent> {
    //     @Override
    //     public void handle(ActionEvent event) {
    //         player.shuffle();
    //         System.out.println("Is playing");
    //     }
    // }

}
