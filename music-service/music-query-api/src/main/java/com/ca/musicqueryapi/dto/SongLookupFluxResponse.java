package com.ca.musicqueryapi.dto;


import com.ca.musiccore.dto.BaseResponse;
import com.ca.musiccore.models.Song;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class SongLookupFluxResponse extends BaseResponse {
    private Flux<Song> songs;

    public SongLookupFluxResponse(String message) {
        super(message);
    }

    public SongLookupFluxResponse(String message, Flux<Song> songs) {
        super(message);
        this.songs= songs;
    }
    public SongLookupFluxResponse(Flux<Song> user) {
        super(null);
        this.songs = user;
    }
    public Flux<Song> getSongs() {
        return songs;
    }

    public void setSongs(Flux<Song> songs) {
        this.songs = songs;
    }
}
