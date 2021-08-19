package com.ca.usercmdapi.controllers;


import com.ca.usercmdapi.commands.RegisterUserCommand;
import com.ca.usercmdapi.dto.RegisterUserResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/registerUser")
public class RegisterUserController {

    private final CommandGateway commandGateway;

    @Autowired
    public RegisterUserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public ResponseEntity<RegisterUserResponse> registerUserResponseResponseEntity(@Valid @RequestBody RegisterUserCommand registerUserCommand) {
        var id = UUID.randomUUID().toString();

        registerUserCommand.setId(id);

        try {
            commandGateway.send(registerUserCommand);
            return new ResponseEntity<>(new RegisterUserResponse(id,"User registered"), HttpStatus.CREATED);
        }
        catch (Exception e) {
            var err = "Error while register user request " + id;
            System.out.println(e.toString());

            return new ResponseEntity<>(new RegisterUserResponse(id, err), HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
}
