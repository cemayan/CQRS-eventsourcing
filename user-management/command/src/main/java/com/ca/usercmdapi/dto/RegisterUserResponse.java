package com.ca.usercmdapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

public class RegisterUserResponse extends  BaseResponse {

    private String id;

    public RegisterUserResponse(String id,String message) {
        super(message);
        this.id = id;
    }
}
