package com.ca.userqueryapi.handlers;

import com.ca.usercore.events.UserRegisteredEvent;
import com.ca.usercore.events.UserRemovedEvent;
import com.ca.usercore.events.UserUpdatedEvent;

public interface UserEventHandler {
    void on(UserRegisteredEvent userRegisteredEvent);
    void on(UserUpdatedEvent userUpdatedEvent);
    void on(UserRemovedEvent userRemovedEvent);
}
