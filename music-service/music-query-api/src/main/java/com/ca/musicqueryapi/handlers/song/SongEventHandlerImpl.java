package com.ca.musicqueryapi.handlers.song;

import com.ca.musiccore.events.song.SongRegisteredEvent;
import com.ca.musiccore.mapper.SongMapper;
import com.ca.musiccore.models.Song;
import com.ca.musicqueryapi.repositories.AlbumRepository;
import com.ca.musicqueryapi.repositories.SongRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("music-group")
public class SongEventHandlerImpl implements SongEventHandler {

    private final SongRepository musicRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public SongEventHandlerImpl(SongRepository musicRepository, AlbumRepository albumRepository) {
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
