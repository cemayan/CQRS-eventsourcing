package com.ca.musicqueryapi.dto;


import com.ca.musiccore.dto.BaseResponse;
import com.ca.musiccore.models.Song;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public class SongLookupResponse extends BaseResponse {
    private List<Song> songs;

    public SongLookupResponse(String message) {
        super(message);
    }

    public SongLookupResponse(Flux<Song> songs) {
        super(null);
        this.songs = songs.collectList().block();
    }

    public SongLookupResponse(String message, Mono<Song> song) {
        super(message);
        songs = song.flux().collectList().block();
    }

    public SongLookupResponse(Mono<Song> user) {
        super(null);
        songs = user.flux().collectList().block();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
