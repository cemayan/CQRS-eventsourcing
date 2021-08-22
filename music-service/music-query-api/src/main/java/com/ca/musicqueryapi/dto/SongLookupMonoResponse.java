package com.ca.musicqueryapi.dto;


import com.ca.musiccore.dto.BaseResponse;
import com.ca.musiccore.dto.SongDTO;
import com.ca.musiccore.mapper.SongMapper;
import com.ca.musiccore.models.Song;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SongLookupMonoResponse extends BaseResponse {

    private SongDTO songDTO;

    public SongLookupMonoResponse(String message) {
        super(message);
    }

    public SongLookupMonoResponse(String message, Song song) {
        super(message);
        this.songDTO = SongMapper.INSTANCE.songToSongDTO( song );

    }
    public SongLookupMonoResponse(Song song) {
        super(null);
        this.songDTO = SongMapper.INSTANCE.songToSongDTO( song );
    }

    public SongDTO getSongDTO() {
        return songDTO;
    }

    public void setSongDTO(SongDTO songDTO) {
        this.songDTO = songDTO;
    }
}
