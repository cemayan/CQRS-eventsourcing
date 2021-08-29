package com.ca.musiccore.events.artist;


import com.ca.musiccore.dto.AlbumDTO;
import com.ca.musiccore.dto.ArtistDTO;


public class ArtistRegisteredEvent {

    private String id;
    private ArtistDTO artist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArtistDTO getArtist() {
        return artist;
    }

    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }
}
