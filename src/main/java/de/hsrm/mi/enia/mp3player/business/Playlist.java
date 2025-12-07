package de.hsrm.mi.enia.mp3player.business;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Playlist {

   private final List<Track> list;
    private final String title;
    private final LocalDate creationDate;
    private final String coverFile;

    public Playlist(String title, LocalDate creationDate, String coverFile) {
        this.list = new ArrayList<>();
        this.creationDate = creationDate;
        this.title = title;
        this.coverFile = coverFile;
    }

    public void addTrack(Track e) {
        list.add(e);

    }

    
    public void removeTrack(Track track) {
        list.remove(track);
    }


    public int numberOfTracks() {
        return list.size();
    }

    public Track getTrack(int number) {
       return list.get(number);
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getCoverFile() {
        return coverFile;
    }

    public List<Track> getList() {
        return list;
    }

}
