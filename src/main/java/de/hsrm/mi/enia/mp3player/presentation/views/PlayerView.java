package de.hsrm.mi.enia.mp3player.presentation.views;

import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ButtonTextPane;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ControlPane;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.CoverViewPane;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.TextPane;
import javafx.scene.layout.BorderPane;


public class PlayerView extends BorderPane {
	
	CoverViewPane cover;
	TextPane songInfo;
	ControlPane controlPane;
	
	

	public PlayerView() {

		cover = new CoverViewPane();
		controlPane = new ControlPane();
		songInfo=new TextPane();
		
		this.setTop(cover);
		this.setCenter(songInfo);
		this.setBottom(controlPane);
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
