package com.ca.musicqueryapi.handlers;

import com.ca.musiccore.events.SongRegisteredEvent;
import com.ca.musiccore.models.Song;
import com.ca.musicqueryapi.repositories.MusicRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("music-group")
public class MusicEventHandlerImpl implements MusicEventHandler {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicEventHandlerImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    @EventHandler
    @Override
    public void on(SongRegisteredEvent songRegisteredEvent) {

        var song = Song.builder()
                .id(songRegisteredEvent.getId())
                .newSong(true)
                .duration(songRegisteredEvent.getSong().getDuration())
                .image(songRegisteredEvent.getSong().getImage())
                .lyrics(songRegisteredEvent.getSong().getLyrics())
                .name(songRegisteredEvent.getSong().getName())
                .spotifyLink(songRegisteredEvent.getSong().getSpotifyLink())
                .youtubeLink(songRegisteredEvent.getSong().getYoutubeLink())
                .version(songRegisteredEvent.getSong().getVersion())
                .build();

        musicRepository.save(song).subscribe();
    }

}
