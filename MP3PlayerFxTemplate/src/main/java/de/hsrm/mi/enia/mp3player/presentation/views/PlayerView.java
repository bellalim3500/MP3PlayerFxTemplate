package de.hsrm.mi.enia.mp3player.presentation.views;

import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ButtonTextPane;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.ControlPane;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.CoverViewPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class PlayerView extends BorderPane {
	
	CoverViewPane coverViewPane;
	ControlPane controlPane;
	
	

	public PlayerView() {

		coverViewPane = new CoverViewPane();
		controlPane = new ControlPane();
		
		this.setCenter(coverViewPane);
		this.setBottom(controlPane);
	}


	public CoverViewPane getCoverViewPane() {
		return coverViewPane;
	}


	public ControlPane getControlPane() {
		return controlPane;
	}


	
	

}
