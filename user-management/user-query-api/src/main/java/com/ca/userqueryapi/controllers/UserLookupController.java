package com.ca.userqueryapi.controllers;


import com.ca.usercore.dto.UserDTO;
import com.ca.userqueryapi.dto.UserLookupResponse;
import com.ca.userqueryapi.queries.FindAllUsersQuery;
import com.ca.userqueryapi.queries.FindUserByIdQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.axonframework.messaging.responsetypes.ResponseTypes;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/v1/userLookup")
public class UserLookupController {
    private final QueryGateway queryGateway;

    @Autowired
    public UserLookupController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public Flux<ResponseEntity<UserLookupResponse>>  getAllUsers() {
        var query = new FindAllUsersQuery();

        var response = queryGateway.query(query, ResponseTypes.instanceOf(Flux.class)).join();
        Flux<UserDTO> userFlux = (Flux<UserDTO>) response;

        return  userFlux
                .map(resp-> ResponseEntity.status(200).body(new UserLookupResponse(resp)));
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public Mono<ResponseEntity<UserLookupResponse>> getUserById(@PathVariable(value = "id") String id) {

        var query = new FindUserByIdQuery(id);

        var response = queryGateway.query(query, ResponseTypes.instanceOf(Mono.class)).join();
        Mono<UserDTO> userMono = (Mono<UserDTO>) response;

        return  userMono
                .map(resp-> ResponseEntity.status(200).body(new UserLookupResponse(resp)))
                .switchIfEmpty(Mono.defer(()-> Mono.error(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  "User with id " + id + " not found!");
                })));
    }
}
