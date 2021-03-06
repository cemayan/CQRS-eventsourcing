package com.ca.musiccmdapi.commands;


import com.ca.musiccore.models.Song;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
public class RegisterAlbumCommand {

    @TargetAggregateIdentifier
    private String id;


    private String name;
    private String recordLabel;
    private Integer year;
    private ZonedDateTime releaseDate;

}
