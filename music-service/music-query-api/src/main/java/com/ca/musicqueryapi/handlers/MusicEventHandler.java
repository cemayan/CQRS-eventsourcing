package com.ca.musicqueryapi.handlers;


import com.ca.musiccore.events.SongRegisteredEvent;
import org.springframework.stereotype.Service;


@Service
public interface MusicEventHandler {
    void on(SongRegisteredEvent songRegisteredEvent);

}
