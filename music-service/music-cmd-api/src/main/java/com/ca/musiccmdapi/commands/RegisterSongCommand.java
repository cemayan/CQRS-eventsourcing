package com.ca.musiccmdapi.commands;


import com.ca.musiccore.dto.SongDTO;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class RegisterSongCommand {

    @TargetAggregateIdentifier
    private String id;

    @NotNull
    @Valid
    private SongDTO song;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SongDTO getSong() {
        return song;
    }

    public void setSong(SongDTO song) {
        this.song = song;
    }
}
