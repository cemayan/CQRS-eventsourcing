package com.ca.musicqueryapi.handlers.song;



import com.ca.musicqueryapi.dto.SongLookupFluxResponse;
import com.ca.musicqueryapi.dto.SongLookupMonoResponse;
import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;
import com.ca.musicqueryapi.repositories.SongRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SongQueryHandlerImpl implements SongQueryHandler {


    private final SongRepository songRepository;

    @Autowired
    public SongQueryHandlerImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void aa() {

    }

    @QueryHandler
    @Override
    public Mono getSongById(FindSongByIdQuery query) {
        var song = songRepository.findById(query.getId());
        return song;
    }



    @QueryHandler
    @Override
    public SongLookupFluxResponse getAllSongs(FindAllSongsQuery query) {
        var songs = songRepository.findAll();
        return new SongLookupFluxResponse(songs);
    }
}
