package com.ca.musicqueryapi.handlers.album;


import com.ca.musiccore.events.album.AlbumRegisteredEvent;
import com.ca.musiccore.events.song.SongRegisteredEvent;
import org.springframework.stereotype.Service;


@Service
public interface AlbumEventHandler {
    void on(AlbumRegisteredEvent albumRegisteredEvent);

}
