package com.ca.musiccore.events.album;


import com.ca.musiccore.dto.AlbumDTO;
import com.ca.musiccore.dto.SongDTO;


public class AlbumRegisteredEvent {

    private String id;
    private AlbumDTO album;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }
}
