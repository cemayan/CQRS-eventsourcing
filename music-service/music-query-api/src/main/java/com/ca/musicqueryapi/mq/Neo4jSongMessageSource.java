package com.ca.musicqueryapi.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Neo4jSongMessageSource {

    @Output("neo4jSongMessageChannel")
    MessageChannel employeeRegistration();
}
