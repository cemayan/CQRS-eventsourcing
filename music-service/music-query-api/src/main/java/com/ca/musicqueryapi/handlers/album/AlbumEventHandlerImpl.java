package com.ca.musicqueryapi.handlers.album;

import com.ca.musiccore.events.album.AlbumRegisteredEvent;
import com.ca.musiccore.events.song.SongRegisteredEvent;
import com.ca.musiccore.mapper.AlbumMapper;
import com.ca.musiccore.mapper.SongMapper;
import com.ca.musiccore.models.Album;
import com.ca.musiccore.models.Song;
import com.ca.musicqueryapi.repositories.AlbumRepository;
import com.ca.musicqueryapi.repositories.SongRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("album-group")
public class AlbumEventHandlerImpl implements AlbumEventHandler {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumEventHandlerImpl( AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @EventHandler
    @Override
    public void on(AlbumRegisteredEvent albumRegisteredEvent) {

       Album album_ = AlbumMapper.INSTANCE.albumEventToAlbum( albumRegisteredEvent );
        album_.setNewAlbum(true);
       albumRepository.save(album_).subscribe();
    }

}
