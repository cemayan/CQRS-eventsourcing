package com.ca.musicqueryapi.handlers.album;



import com.ca.musicqueryapi.dto.SongLookupResponse;
import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;
import com.ca.musicqueryapi.repositories.SongRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongQueryHandlerImpl implements SongQueryHandler {


    private final SongRepository songRepository;

    @Autowired
    public SongQueryHandlerImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @QueryHandler
    @Override
    public SongLookupResponse getSongById(FindSongByIdQuery query) {
        var song = songRepository.findById(query.getId());
        return new SongLookupResponse(song);
    }

    @QueryHandler
    @Override
    public SongLookupResponse getAllSongs(FindAllSongsQuery query) {
        var songs = songRepository.findAll();
        return new SongLookupResponse(songs);
    }
}
