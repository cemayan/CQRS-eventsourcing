package com.ca.musiccmdapi.aggregates;

import com.ca.musiccmdapi.commands.RegisterSongCommand;
import com.ca.musiccmdapi.mapper.MusicCommandMapper;
import com.ca.musiccore.dto.SongDTO;
import com.ca.musiccore.events.SongRegisteredEvent;
import com.ca.musiccore.mapper.SongMapper;
import com.ca.musiccore.models.Song;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class MusicAggregate {

    @AggregateIdentifier
    private String id;
    private SongDTO song;

    @CommandHandler
    public  MusicAggregate(RegisterSongCommand  command) {

        SongRegisteredEvent songRegisteredEvent =
                MusicCommandMapper.INSTANCE.registerSongCommandToSongRegisteredEvent(command);

        AggregateLifecycle.apply(songRegisteredEvent);
    }

    @EventSourcingHandler
    public void on(SongRegisteredEvent event) {
        this.id = event.getId();
        this.song = event.getSong();
    }


}
