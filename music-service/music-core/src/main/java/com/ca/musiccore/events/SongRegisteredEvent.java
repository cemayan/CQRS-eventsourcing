package com.ca.musiccore.events;


import com.ca.musiccore.models.Song;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class SongRegisteredEvent {

    private String id;
    private Song song;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
