package com.ca.musicqueryapi.handlers.album;


import com.ca.musicqueryapi.dto.SongLookupResponse;
import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;

public interface SongQueryHandler {
    SongLookupResponse getSongById(FindSongByIdQuery query);
    SongLookupResponse getAllSongs(FindAllSongsQuery query);
}
