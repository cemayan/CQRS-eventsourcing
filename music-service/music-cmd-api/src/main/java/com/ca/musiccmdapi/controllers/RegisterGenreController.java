package com.ca.musiccmdapi.controllers;



import com.ca.musiccmdapi.commands.RegisterAlbumCommand;
import com.ca.musiccmdapi.commands.RegisterGenreCommand;
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
@RequestMapping("/api/v1/registerGenre")
public class RegisterGenreController {

    private final CommandGateway commandGateway;

    @Autowired
    public RegisterGenreController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<RegisterSongResponse> registerUserResponseResponseEntity(@Valid @RequestBody RegisterGenreCommand registerGenreCommand) {
        var id = UUID.randomUUID().toString();

        registerGenreCommand.setId(id);

        try {
            commandGateway.send(registerGenreCommand);
            return new ResponseEntity<>(new RegisterSongResponse(id,"Genre registered"), HttpStatus.CREATED);
        }
        catch (Exception e) {
            var err = "Error while register user request " + id;
            System.out.println(e.toString());

            return new ResponseEntity<>(new RegisterSongResponse(id, err), HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
}
