package com.ca.musiccmdapi.controllers;


import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/registerMusic")
public class RegisterMusicController {

    private final CommandGateway commandGateway;

    @Autowired
    public RegisterMusicController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public Mono<String> aa() {
        return Mono.just("asds");
    }
}
