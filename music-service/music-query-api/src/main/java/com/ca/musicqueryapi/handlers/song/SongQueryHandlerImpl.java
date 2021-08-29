package com.ca.musicqueryapi.handlers.song;



import com.ca.musiccore.mapper.SongMapper;
import com.ca.musicqueryapi.config.RibbonConfig;
import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;
import com.ca.musicqueryapi.repositories.SongRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RibbonClient(
        name = "user-query-service",
        configuration = RibbonConfig.class)
public class SongQueryHandlerImpl implements SongQueryHandler {


    private final SongRepository songRepository;
    private  WebClient webClient;
    private final ReactiveCircuitBreaker reactiveCircuitBreaker;

    @Autowired
    public SongQueryHandlerImpl(SongRepository songRepository,
                                WebClient.Builder webClientBuilder,
                                ReactiveCircuitBreakerFactory circuitBreakerFactory) {
        this.songRepository = songRepository;
        this.webClient = webClientBuilder.baseUrl("http://user-query-service").build();
        this.reactiveCircuitBreaker = circuitBreakerFactory.create("getUser");
    }


    @QueryHandler
    @Override
    public Mono getSongById(FindSongByIdQuery query) {
        var song = songRepository.findById(query.getId());
        return song.map(x-> SongMapper.INSTANCE.songToSongDTO(x));
    }


    @QueryHandler
    @Override
    public Flux getAllSongs(FindAllSongsQuery query) {
        var songs = songRepository.findAll();
        return songs.map(x-> SongMapper.INSTANCE.songToSongDTO(x));
    }

    @Override
    public Mono getUser(String userId, String authToken) {

        return reactiveCircuitBreaker.run(webClient
                .get()
                .uri("/api/v1/userLookup/" + userId)
                .header("Authorization", authToken)
                .retrieve()
                .bodyToMono(String.class), throwable -> {
            return Mono.just(throwable.getMessage());
        });
    }
}
