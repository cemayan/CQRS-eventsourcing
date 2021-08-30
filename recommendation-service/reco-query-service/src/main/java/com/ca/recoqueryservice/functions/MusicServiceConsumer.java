package com.ca.recoqueryservice.functions;


import com.ca.recocore.dto.AllSongRegisteredEvent;
import com.ca.recocore.dto.music.SongDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Component
public class MusicServiceConsumer {

    @Bean
    public Consumer<AllSongRegisteredEvent> onReceive() {
        return (message) -> {
            System.out.println(message);
        };
    }
}