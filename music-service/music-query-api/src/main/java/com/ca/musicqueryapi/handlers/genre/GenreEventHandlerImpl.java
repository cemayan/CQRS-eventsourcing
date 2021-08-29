package com.ca.musicqueryapi.handlers.genre;

import com.ca.musiccore.events.artist.ArtistRegisteredEvent;
import com.ca.musiccore.events.genre.GenreRegisteredEvent;
import com.ca.musiccore.mapper.ArtistMapper;
import com.ca.musiccore.mapper.GenreMapper;
import com.ca.musiccore.models.Artist;
import com.ca.musiccore.models.Genre;
import com.ca.musicqueryapi.repositories.ArtistRepository;
import com.ca.musicqueryapi.repositories.GenreRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("genre-group")
public class GenreEventHandlerImpl implements GenreEventHandler {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreEventHandlerImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }



    @EventHandler
    @Override
    public void on(GenreRegisteredEvent genreRegisteredEvent) {

       Genre genre_ = GenreMapper.INSTANCE.genreEventToGenre( genreRegisteredEvent );
        genre_.setNewGenre(true);
       genreRepository.save(genre_).subscribe();
    }

}
