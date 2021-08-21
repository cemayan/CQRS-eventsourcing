package com.ca.musiccore.events;


import com.ca.musiccore.dto.SongDTO;


public class SongRegisteredEvent {

    private String id;
    private SongDTO song;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SongDTO getSong() {
        return song;
    }

    public void setSong(SongDTO song) {
        this.song = song;
    }
}
