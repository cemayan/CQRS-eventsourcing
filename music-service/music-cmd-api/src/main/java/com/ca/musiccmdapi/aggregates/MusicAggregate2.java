package com.ca.musiccmdapi.aggregates;

import com.ca.musiccmdapi.commands.RegisterAllSongCommand;
import com.ca.musiccmdapi.commands.RegisterSongCommand;
import com.ca.musiccmdapi.mapper.MusicCommandMapper;
import com.ca.musiccore.dto.AlbumDTO;
import com.ca.musiccore.dto.ArtistDTO;
import com.ca.musiccore.dto.GenreDTO;
import com.ca.musiccore.dto.SongDTO;
import com.ca.musiccore.events.song.AllSongRegisteredEvent;
import com.ca.musiccore.events.song.SongRegisteredEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class MusicAggregate2 {

    @AggregateIdentifier
    private String id;
    private SongDTO song;
    private AlbumDTO album;
    private ArtistDTO artist;
    private GenreDTO genre;

    @CommandHandler
    public MusicAggregate2(RegisterAllSongCommand  command) {

        AllSongRegisteredEvent songRegisteredEvent =
                MusicCommandMapper.INSTANCE.registerSongCommandToAllSongRegisteredEvent(command);
        AggregateLifecycle.apply(songRegisteredEvent);
    }



    @EventSourcingHandler
    public void on(AllSongRegisteredEvent event) {
        this.id = event.getId();
        this.song = event.getSong();
        this.genre = event.getGenre();
        this.artist = event.getArtist();
        this.album = event.getAlbum();
    }




}
