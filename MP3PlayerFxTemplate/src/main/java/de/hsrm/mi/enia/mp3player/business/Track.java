package de.hsrm.mi.enia.mp3player.business;

import java.io.ByteArrayInputStream;

import javafx.scene.image.Image;

public class Track {

    long id;
    String title;
    long length;
    String albumTitle;
    String interpret;
    String soundFile;
    byte[]albumImage;

    public Track(String albumTitle, String interpret, long length, String soundFile, String title, byte[]albumImage) {
        this.albumTitle = albumTitle;
        this.interpret = interpret;
        this.length = length;
        this.soundFile = soundFile;
        this.title = title;
        this.albumImage=albumImage;
    }

    public long getId() {
        return id;
    }

    public Image getAlbumImage() {
       if (albumImage != null) {
            return new Image(new ByteArrayInputStream(albumImage));
        } else {
            return null;
        }
    }
    

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public String getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(String soundFile) {
        this.soundFile = soundFile;
    }

    


    
}
