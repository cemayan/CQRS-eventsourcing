package com.ca.usercore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection =  "users")
public class User {

    @Id
    private String id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastname;

    @Email
    private String emailAddress;

    @NotNull
    private Account account;
}
