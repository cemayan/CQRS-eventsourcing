package com.ca.usercmdapi.commands;

import com.ca.usercore.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateUserCommand {

    @TargetAggregateIdentifier
    private String id;

    private User user;
}
