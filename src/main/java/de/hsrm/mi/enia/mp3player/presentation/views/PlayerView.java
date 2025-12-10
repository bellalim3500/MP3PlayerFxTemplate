package de.hsrm.mi.enia.mp3player.presentation.views;

import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ControlPane;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.CoverViewPane;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.TextPane;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class PlayerView extends BorderPane {
	
	CoverViewPane cover;
	TextPane songInfo;
	ControlPane controlPane;
	private VBox view;
	
	

	public PlayerView() {

		view= new VBox(10);
		view.setAlignment(Pos.CENTER);
		
		cover = new CoverViewPane();
		cover.setMinHeight(200);
		cover.setMaxHeight(Double.MAX_VALUE);

		controlPane = new ControlPane();
		songInfo=new TextPane();
		songInfo.setMaxWidth(Double.MAX_VALUE);
		
		view.getChildren().addAll(cover, songInfo);
		VBox.setVgrow(cover,Priority.ALWAYS);
		this.setCenter(view);
		this.setBottom(controlPane);
		

		BorderPane.setAlignment(view, Pos.CENTER);
		BorderPane.setAlignment(controlPane,Pos.CENTER);
	
	}


	public CoverViewPane getCoverViewPane() {
		return cover;
	}


	public ControlPane getControlPane() {
		return controlPane;
	}


	public TextPane getSongInfo() {
		return songInfo;
	}


	
	

}
