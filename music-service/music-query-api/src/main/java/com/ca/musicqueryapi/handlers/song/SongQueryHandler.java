package com.ca.musicqueryapi.handlers.song;


import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SongQueryHandler {
    Mono  getSongById(FindSongByIdQuery query);
    Flux getAllSongs(FindAllSongsQuery query);
    Mono getUser(String userId, String authToken);
}
