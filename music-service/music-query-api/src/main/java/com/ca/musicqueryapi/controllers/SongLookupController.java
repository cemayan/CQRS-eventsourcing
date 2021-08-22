package com.ca.musicqueryapi.controllers;

import com.ca.musiccore.models.Song;
import com.ca.musicqueryapi.dto.SongLookupFluxResponse;
import com.ca.musicqueryapi.dto.SongLookupMonoResponse;
import com.ca.musicqueryapi.handlers.song.SongQueryHandler;
import com.ca.musicqueryapi.queries.FindAllSongsQuery;
import com.ca.musicqueryapi.queries.FindSongByIdQuery;
import org.axonframework.extensions.reactor.queryhandling.gateway.ReactorQueryGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.GenericQueryMessage;
import org.axonframework.queryhandling.GenericQueryResponseMessage;
import org.axonframework.queryhandling.QueryBus;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping(path = "/api/v1/songLookup")
public class SongLookupController {

    private final QueryGateway queryGateway;
    private final ReactorQueryGateway reactiveQueryGateway;
    private final QueryBus queryBus;
    private SongQueryHandler songQueryHandler;


    @Autowired
    public SongLookupController(QueryGateway queryGateway, ReactorQueryGateway reactiveQueryGateway, QueryBus queryBus, SongQueryHandler songQueryHandler) {
        this.queryGateway = queryGateway;
        this.reactiveQueryGateway = reactiveQueryGateway;
        this.queryBus = queryBus;
        this.songQueryHandler = songQueryHandler;
    }

    @GetMapping(path = "/")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public ResponseEntity<SongLookupFluxResponse> getAllUsers() {
        try {
            var query = new FindAllSongsQuery();
            var response = queryGateway.query(query, ResponseTypes.instanceOf(SongLookupFluxResponse.class)).join();

            if (response == null || response.getSongs() == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete get all songs request";
            System.out.println(e.toString());

            return new ResponseEntity<>(new SongLookupFluxResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public Mono<ResponseEntity> getUserById(@PathVariable(value = "id") String id) {

        var query = new FindSongByIdQuery(id);

        GenericQueryMessage queryMessage =
                new GenericQueryMessage(query, ResponseTypes.instanceOf(Mono.class));

        CompletableFuture completableFuture = queryBus.query(queryMessage);

        GenericQueryResponseMessage queryResponseMessage =
                (GenericQueryResponseMessage) completableFuture.join();

        Mono<Song> songMono = (Mono<Song>) queryResponseMessage.getPayload();

        return  songMono
                .map(resp-> ResponseEntity.status(200).body(new  SongLookupMonoResponse(resp)));
    }
}
