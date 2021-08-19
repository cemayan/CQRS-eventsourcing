package com.ca.usercmdapi.aggregates;

import com.ca.usercmdapi.commands.RegisterUserCommand;
import com.ca.usercmdapi.commands.RemoveUserCommand;
import com.ca.usercmdapi.commands.UpdateUserCommand;
import com.ca.usercmdapi.security.PasswordEncoder;
import com.ca.usercmdapi.security.PasswordEncoderImpl;
import com.ca.usercore.events.UserRegisteredEvent;
import com.ca.usercore.events.UserRemovedEvent;
import com.ca.usercore.events.UserUpdatedEvent;
import com.ca.usercore.models.User;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private String id;
    private User user;

    private final PasswordEncoder passwordEncoder;

    public UserAggregate() {
        passwordEncoder = new PasswordEncoderImpl();
    }

    @CommandHandler
    public UserAggregate(RegisterUserCommand command) {
        var newUser = command.getUser();
        newUser.setId(command.getId());
        var password= newUser.getAccount().getPassword();
        passwordEncoder = new PasswordEncoderImpl();

        var hassPassword = passwordEncoder.hashPassword(password);
        newUser.getAccount().setPassword(hassPassword);

        var event = UserRegisteredEvent.builder()
                .id(command.getId())
                .user(newUser)
                .build();

        AggregateLifecycle.apply(event);

    }

    @CommandHandler
    public void handle(UpdateUserCommand command) {
        var updatedUser = command.getUser();
        updatedUser.setId(command.getId());
        var password= updatedUser.getAccount().getPassword();
        var hassPassword = passwordEncoder.hashPassword(password);
        updatedUser.getAccount().setPassword(hassPassword);

        var event = UserUpdatedEvent.builder()
                .id(UUID.randomUUID().toString())
                .user(updatedUser)
                .build();

        AggregateLifecycle.apply(event);

    }

    @CommandHandler
    public void handle(RemoveUserCommand command) {
        var event = new UserRemovedEvent();
        event.setId(command.getId());

        AggregateLifecycle.apply(event);

    }

    @EventSourcingHandler
    public void on(UserRegisteredEvent event) {
        this.id = event.getId();
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserUpdatedEvent event) {
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserRemovedEvent event) {
        AggregateLifecycle.markDeleted();
    }

}
