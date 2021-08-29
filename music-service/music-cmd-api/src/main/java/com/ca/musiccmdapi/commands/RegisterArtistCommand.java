package com.ca.musiccmdapi.commands;


import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class RegisterArtistCommand {

    @TargetAggregateIdentifier
    private String id;

    @NotNull
    @Valid
    private String name;
}
