package com.ca.userqueryapi.handlers;

import com.ca.usercore.events.UserRegisteredEvent;
import com.ca.usercore.events.UserRemovedEvent;
import com.ca.usercore.events.UserUpdatedEvent;
import com.ca.userqueryapi.repositories.UserRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("user-group")
public class UserEventHandlerImpl implements UserEventHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserEventHandlerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @EventHandler
    @Override
    public void on(UserRegisteredEvent userRegisteredEvent) {
        userRepository.save(userRegisteredEvent.getUser()).subscribe();
    }


    @EventHandler
    @Override
    public void on(UserUpdatedEvent userUpdatedEvent) {

        userRepository.save(userUpdatedEvent.getUser()).subscribe();
    }


    @EventHandler
    @Override
    public void on(UserRemovedEvent userRemovedEvent) {
        userRepository.deleteById(userRemovedEvent.getId()).subscribe();
    }
}
