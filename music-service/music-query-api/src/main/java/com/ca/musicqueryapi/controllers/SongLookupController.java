package com.ca.musicqueryapi.controllers;

import com.ca.musiccore.dto.SongDTO;
import com.ca.musicqueryapi.dto.SongLookupResponse;
import com.ca.musicqueryapi.handlers.song.SongQueryHandler;
import com.ca.musicqueryapi.handlers.song.SongQueryHandlerImpl;
import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;
import org.axonframework.extensions.reactor.queryhandling.gateway.ReactorQueryGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryBus;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(path = "/api/v1/songLookup")
public class SongLookupController {

    private final QueryGateway queryGateway;
    private final ReactorQueryGateway reactiveQueryGateway;
    private final QueryBus queryBus;
    private SongQueryHandlerImpl songQueryHandler;


    @Autowired
    public SongLookupController(QueryGateway queryGateway,
                                ReactorQueryGateway reactiveQueryGateway,
                                QueryBus queryBus,
                                SongQueryHandlerImpl songQueryHandler) {
        this.queryGateway = queryGateway;
        this.reactiveQueryGateway = reactiveQueryGateway;
        this.queryBus = queryBus;
        this.songQueryHandler = songQueryHandler;
    }

    @GetMapping(path = "/")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public Flux<ResponseEntity<SongLookupResponse>> getAllSongs() {
            var query = new FindAllSongsQuery();
            var response = queryGateway.query(query, ResponseTypes.instanceOf(Flux.class)).join();
            Flux<SongDTO> songDTOFlux = (Flux<SongDTO> ) response;

            return  songDTOFlux
                    .map(resp-> ResponseEntity.status(200).body(new SongLookupResponse(resp)));
    }


    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public Mono<ResponseEntity<SongLookupResponse>> getSongById(
            @PathVariable(value = "id") String id,
            @RequestHeader(name="Authorization") String token) {

        var query = new FindSongByIdQuery(id);

        var response = queryGateway.query(query, ResponseTypes.instanceOf(Mono.class)).join();
        Mono<SongDTO> songMono = (Mono<SongDTO>) response;

        return  songMono
                .map(resp-> ResponseEntity.status(200).body(new SongLookupResponse(resp)))
                .switchIfEmpty(Mono.defer(()-> Mono.error(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  "Song with id " + id + " not found!");
                })));
    }

}
