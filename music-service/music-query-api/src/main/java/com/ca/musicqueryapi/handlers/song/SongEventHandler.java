package com.ca.musicqueryapi.handlers.song;


import com.ca.musiccore.events.song.SongRegisteredEvent;
import org.springframework.stereotype.Service;


@Service
public interface SongEventHandler {
    void on(SongRegisteredEvent songRegisteredEvent);

}
