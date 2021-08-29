package com.ca.musicqueryapi.dto;


import com.ca.musiccore.dto.BaseResponse;
import com.ca.musiccore.dto.SongDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SongLookupResponse extends BaseResponse {

    private SongDTO songDTO;

    public SongLookupResponse(String message) {
        super(message);
    }

    public SongLookupResponse(String message, SongDTO songDTO_) {
        super(message);
        this.songDTO = songDTO_;
    }
    public SongLookupResponse(SongDTO songDTO_) {
        super(null);
        this.songDTO = songDTO_;
    }

    public SongDTO getSongDTO() {
        return songDTO;
    }

    public void setSongDTO(SongDTO songDTO) {
        this.songDTO = songDTO;
    }
}
