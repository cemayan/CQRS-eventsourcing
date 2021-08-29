package com.ca.musiccmdapi.controllers;



import com.ca.musiccmdapi.commands.RegisterArtistCommand;
import com.ca.musiccmdapi.commands.RegisterSongCommand;
import com.ca.musiccmdapi.dto.RegisterSongResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/registerArtist")
public class RegisterArtistController {

    private final CommandGateway commandGateway;

    @Autowired
    public RegisterArtistController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<RegisterSongResponse> registerUserResponseResponseEntity(@Valid @RequestBody RegisterArtistCommand registerArtistCommand) {
        var id = UUID.randomUUID().toString();

        registerArtistCommand.setId(id);

        try {
            commandGateway.send(registerArtistCommand);
            return new ResponseEntity<>(new RegisterSongResponse(id,"Artist registered"), HttpStatus.CREATED);
        }
        catch (Exception e) {
            var err = "Error while register user request " + id;
            System.out.println(e.toString());

            return new ResponseEntity<>(new RegisterSongResponse(id, err), HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
}
