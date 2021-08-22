package com.ca.musicqueryapi.handlers.song;


import com.ca.musiccore.models.Song;
import com.ca.musicqueryapi.dto.SongLookupFluxResponse;
import com.ca.musicqueryapi.dto.SongLookupMonoResponse;
import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public interface SongQueryHandler {
    Mono  getSongById(FindSongByIdQuery query);
    SongLookupFluxResponse getAllSongs(FindAllSongsQuery query);
}
