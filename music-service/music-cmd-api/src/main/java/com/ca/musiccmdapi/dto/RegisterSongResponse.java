package com.ca.musiccmdapi.dto;


public class RegisterSongResponse extends  BaseResponse {

    private String id;

    public RegisterSongResponse(String id,String message) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
