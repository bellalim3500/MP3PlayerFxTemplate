package de.hsrm.mi.enia.mp3player.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

public class PlaylistManager {

    private Map<String, Playlist> playlist;

    public PlaylistManager() throws UnsupportedTagException, InvalidDataException {
        playlist = new HashMap<>();
        makePlaylist("AllTracks", null, null, "playlist1.m3u");

    }

    public Playlist gePlaylist(String name) {
        return playlist.get(name);
    }

    public Playlist getAllTracks() {
        return playlist.get("AllTracks");
    }

    public void makePlaylist(String title, Date creationDate, String coverFile, String file)
            throws UnsupportedTagException, InvalidDataException {

        Playlist tracks = new Playlist(title, creationDate, coverFile);

        try {
            if (file != null) {
                String pfad = "MP3PlayerFxTemplate" + File.separator + "music" + File.separator;
                

                BufferedReader reader = new BufferedReader(new FileReader(pfad + file));

                String line;
                while ((line = reader.readLine()) != null && !line.equals("")) {

                    Mp3File mp3 = new Mp3File("MP3PlayerFxTemplate" + File.separator + "music" + File.separator + line);

                    if (mp3.hasId3v2Tag()) {
                        ID3v2 tag = mp3.getId3v2Tag();

                        Track track = new Track(tag.getAlbum(), tag.getArtist(), tag.getLength(), "music/" + line,
                                tag.getTitle(), tag.getAlbumImage());
                        tracks.addTrack(track);
                    }
                }
                reader.close();
            }
            playlist.put(title, tracks);

        } catch (FileNotFoundException e) {
            System.err.println("Datei nicht gefunden");

        } catch (IOException e) {
            System.err.println("Datei konnte nicht gelesen werden");
        }

    }

}
