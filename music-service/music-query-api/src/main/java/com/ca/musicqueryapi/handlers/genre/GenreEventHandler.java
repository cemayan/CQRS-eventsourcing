package com.ca.musicqueryapi.handlers.genre;


import com.ca.musiccore.events.artist.ArtistRegisteredEvent;
import com.ca.musiccore.events.genre.GenreRegisteredEvent;
import org.springframework.stereotype.Service;


@Service
public interface GenreEventHandler {
    void on(GenreRegisteredEvent genreRegisteredEvent);

}
