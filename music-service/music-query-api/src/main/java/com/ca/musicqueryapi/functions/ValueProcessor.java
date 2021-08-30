package com.ca.musicqueryapi.functions;


import com.ca.musiccore.dto.SongDTO;
import com.ca.musiccore.events.song.AllSongRegisteredEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;



@Component
public class ValueProcessor {

    @Bean
    public Function<AllSongRegisteredEvent, AllSongRegisteredEvent> sendNeo4j() {
        return (value) -> {
            System.out.println(value);
            return value;
        };
    }
}