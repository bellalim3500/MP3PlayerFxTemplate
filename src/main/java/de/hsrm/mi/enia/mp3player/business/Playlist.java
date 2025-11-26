package de.hsrm.mi.enia.mp3player.business;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Playlist {

    private List<Track> list;
    private String title;
    private Date creationDate;
    private String coverFile;

    public Playlist(String title, Date creationDate, String coverFile) {
        this.list = new ArrayList<>();

        this.creationDate = creationDate;
        this.title = title;
        this.coverFile = coverFile;
    }

    public void addTrack(Track e) {
        list.add(e);

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

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCoverFile() {
        return coverFile;
    }

    public List<Track> getList() {
        return list;
    }

}
