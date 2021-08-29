package com.ca.musiccmdapi.commands;


import com.ca.musiccore.dto.AlbumDTO;
import com.ca.musiccore.dto.ArtistDTO;
import com.ca.musiccore.dto.GenreDTO;
import com.ca.musiccore.dto.SongDTO;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class RegisterAllSongCommand {

    @TargetAggregateIdentifier
    private String id;

    @NotNull
    @Valid
    private SongDTO song;


    @NotNull
    @Valid
    private AlbumDTO album;


    @NotNull
    @Valid
    private ArtistDTO artist;


    @NotNull
    @Valid
    private GenreDTO genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SongDTO getSong() {
        return song;
    }

    public void setSong(SongDTO song) {
        this.song = song;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    public ArtistDTO getArtist() {
        return artist;
    }

    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }
}
