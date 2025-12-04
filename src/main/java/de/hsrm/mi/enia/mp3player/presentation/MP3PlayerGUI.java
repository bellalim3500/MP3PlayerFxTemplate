package de.hsrm.mi.enia.mp3player.presentation;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import de.hsrm.mi.enia.mp3player.business.MP3Player;
import de.hsrm.mi.enia.mp3player.business.Playlist;
import de.hsrm.mi.enia.mp3player.business.PlaylistManager;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.NavToolbar;
import de.hsrm.mi.enia.mp3player.presentation.uiComponents.NavToolbarController;
import de.hsrm.mi.enia.mp3player.presentation.views.DashboardView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlayerView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlayerViewController;
import de.hsrm.mi.enia.mp3player.presentation.views.PlaylistView;
import de.hsrm.mi.enia.mp3player.presentation.views.PlaylistViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;

/**
 * Hauptfenster für PlayerGUI, bettet die PlayerView
 * als erste Hauptsicht zur Steuerung des Players ein.
 */
public class MP3PlayerGUI extends Application {

	private Stage primaryStage;
	private PlayerView playerView;
	private PlaylistView playlistView;
	private PlayerViewController playerViewController;
	private PlaylistManager playlistManager;
	private MP3Player player;

	private DashboardView homeView;

	private Map<String, Pane> views;

	@Override
	public void init() {

		// Initialisierung der Businessklassen
		views = new HashMap<>();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		
		player = new MP3Player();
		playlistManager = new PlaylistManager();
		Playlist playlist = playlistManager.getAllTracks();
		player.setAktPlaylist(playlist);

		homeView = new DashboardView();
		playerView = new PlayerView();
		playlistView = new PlaylistView();

		

		views.put("playerView", playerView);
		views.put("playlistView", playlistView);
		views.put("homeView", homeView);

		this.playerViewController = new PlayerViewController(playerView, player);
		playerViewController.initalize();
		PlaylistViewController playlistViewController = new PlaylistViewController(playlistView,player, playlistManager);
		playlistViewController.initalize();

		// weitere Controller TODO

		NavToolbar navToolbar = new NavToolbar();

		StackPane contentPane = new StackPane( playlistView, playerView);

		playlistView.setVisible(true);
		playerView.setVisible(false);


		NavToolbarController navToolbarController = new NavToolbarController(navToolbar, playerView,
				playlistView);
		navToolbarController.initalize();

		BorderPane root = new BorderPane();
		root.setCenter(contentPane);
		root.setBottom(navToolbar);

		this.primaryStage = primaryStage;
		Scene scene = new Scene(root, 500, 400);
		scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
		primaryStage.setScene(scene);

		// switchRoot("PLAYER");
		primaryStage.setTitle("Player");
		primaryStage.show();
		this.primaryStage = primaryStage;

	}

	@Override
	public void stop() {
		// Beeneden moeglicher Prozesse - z.B. das Abspielen von Songs

	}

	// public static void switchRoot(String name) {
	// Scene scene = primaryStage.getScene();
	// switch (name) {
	// case "PLAYER":
	// scene.setRoot(playerView);
	// break;
	// case "PLAYLIST":
	// scene.setRoot(playlistView);
	// break;

	// default:
	// break;
	// }
	// }

}
