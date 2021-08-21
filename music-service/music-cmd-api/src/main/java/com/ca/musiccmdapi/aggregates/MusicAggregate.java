package com.ca.musiccmdapi.aggregates;

import com.ca.musiccmdapi.commands.RegisterSongCommand;
import com.ca.musiccore.events.SongRegisteredEvent;
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
    private Song song;

    @CommandHandler
    public  MusicAggregate(RegisterSongCommand  command) {


        SongRegisteredEvent song = SongRegisteredEvent.builder()
                .song(command.getSong())
                .id(command.getId())
                .build();

        AggregateLifecycle.apply(song);

    }

    @EventSourcingHandler
    public void on(SongRegisteredEvent event) {
        this.id = event.getId();
        this.song = event.getSong();
    }


}
