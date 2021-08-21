package com.ca.musicqueryapi.handlers;

import com.ca.musiccore.events.SongRegisteredEvent;
import com.ca.musiccore.mapper.SongMapper;
import com.ca.musiccore.models.Song;
import com.ca.musicqueryapi.repositories.AlbumRepository;
import com.ca.musicqueryapi.repositories.MusicRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("music-group")
public class MusicEventHandlerImpl implements MusicEventHandler {

    private final MusicRepository musicRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public MusicEventHandlerImpl(MusicRepository musicRepository, AlbumRepository albumRepository) {
        this.musicRepository = musicRepository;
        this.albumRepository = albumRepository;
    }


    @EventHandler
    @Override
    public void on(SongRegisteredEvent songRegisteredEvent) {

       Song song_ = SongMapper.INSTANCE.songEventToSong( songRegisteredEvent );
       song_.setNewSong(true);

       musicRepository.save(song_).subscribe();
    }

}
