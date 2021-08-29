package com.ca.musicqueryapi.handlers.artist;

import com.ca.musiccore.events.album.AlbumRegisteredEvent;
import com.ca.musiccore.events.artist.ArtistRegisteredEvent;
import com.ca.musiccore.mapper.AlbumMapper;
import com.ca.musiccore.mapper.ArtistMapper;
import com.ca.musiccore.models.Album;
import com.ca.musiccore.models.Artist;
import com.ca.musicqueryapi.repositories.AlbumRepository;
import com.ca.musicqueryapi.repositories.ArtistRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("artist-group")
public class ArtistEventHandlerImpl implements ArtistEventHandler {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistEventHandlerImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @EventHandler
    @Override
    public void on(ArtistRegisteredEvent artistRegisteredEvent) {

       Artist artist_ = ArtistMapper.INSTANCE.artistEventToArtist( artistRegisteredEvent );
        artist_.setNewArtist(true);
       artistRepository.save(artist_).subscribe();
    }

}
