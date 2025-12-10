package de.hsrm.mi.enia.mp3player.presentation;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.business.Playlist;
import de.hsrm.mi.enia.mp3player.business.PlaylistManager;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.NavToolbar;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.NavToolbarController;
import de.hsrm.mi.enia.mp3player.presentation.views.PlayerView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlayerViewController;
import de.hsrm.mi.enia.mp3player.presentation.views.PlaylistView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlaylistViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Hauptfenster für PlayerGUI, bettet die PlayerView
 * als erste Hauptsicht zur Steuerung des Players ein.
 */
public class MP3PlayerGUI extends Application {

	private Stage primaryStage;
	private PlayerView playerView;
	private PlaylistView playlistView;
	private PlaylistManager playlistManager;
	private MP3Player player;

	@Override
	public void init() {

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		player = new MP3Player();

		playlistManager = new PlaylistManager();
		Playlist playlist = playlistManager.getAllTracks();
		player.setAktPlaylist(playlist);

		playerView = new PlayerView();
		playlistView = new PlaylistView();

		PlayerViewController playerViewController = new PlayerViewController(playerView, player);
		PlaylistViewController playlistViewController = new PlaylistViewController(playlistView, player,
				playlistManager);
		NavToolbar navToolbar = new NavToolbar();

		BorderPane root = new BorderPane();
		root.setCenter(playlistView);
		root.setBottom(navToolbar);
		NavToolbarController navToolbarController = new NavToolbarController(navToolbar, playerView, playlistView,
				root);

		this.primaryStage = primaryStage;
		Scene scene = new Scene(root, 500, 400);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
		primaryStage.setScene(scene);

		primaryStage.setTitle("Player");
		primaryStage.show();

	}

	@Override
	public void stop() {

	}

}
