package com.ca.usercore.events;

import com.ca.usercore.models.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserRemovedEvent {

    private String id;

}
