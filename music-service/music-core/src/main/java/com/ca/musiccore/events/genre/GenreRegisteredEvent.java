package com.ca.musiccore.events.genre;



import com.ca.musiccore.dto.GenreDTO;


public class GenreRegisteredEvent {

    private String id;
    private GenreDTO genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }
}
