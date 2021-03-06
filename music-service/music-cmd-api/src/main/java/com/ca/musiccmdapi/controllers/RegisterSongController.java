package com.ca.musiccmdapi.controllers;



import com.ca.musiccmdapi.commands.RegisterAllSongCommand;
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
@RequestMapping("/api/v1/registerSong")
public class RegisterSongController {

    private final CommandGateway commandGateway;

    @Autowired
    public RegisterSongController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<RegisterSongResponse> registerSong(@Valid @RequestBody RegisterSongCommand registerSongCommand) {
        var id = UUID.randomUUID().toString();

        registerSongCommand.setId(id);

        try {
            commandGateway.send(registerSongCommand);
            return new ResponseEntity<>(new RegisterSongResponse(id,"Song registered"), HttpStatus.CREATED);
        }
        catch (Exception e) {
            var err = "Error while register user request " + id;
            System.out.println(e.toString());

            return new ResponseEntity<>(new RegisterSongResponse(id, err), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/all")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<RegisterSongResponse> registerAllSong(@Valid @RequestBody RegisterAllSongCommand registerAllSongCommand) {
        var id = UUID.randomUUID().toString();

        registerAllSongCommand.setId(id);

        try {
            commandGateway.send(registerAllSongCommand);
            return new ResponseEntity<>(new RegisterSongResponse(id,"Song registered"), HttpStatus.CREATED);
        }
        catch (Exception e) {
            var err = "Error while register user request " + id;
            System.out.println(e.toString());

            return new ResponseEntity<>(new RegisterSongResponse(id, err), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
