package com.ca.musiccmdapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;



public class BaseResponse {

    private String message;

    public BaseResponse(String message) {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
