package com.ca.musicqueryapi.handlers.artist;


import com.ca.musiccore.events.album.AlbumRegisteredEvent;
import com.ca.musiccore.events.artist.ArtistRegisteredEvent;
import org.springframework.stereotype.Service;


@Service
public interface ArtistEventHandler {
    void on(ArtistRegisteredEvent artistRegisteredEvent);

}
