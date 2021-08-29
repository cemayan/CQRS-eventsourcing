package com.ca.musiccore.events.song;


import com.ca.musiccore.dto.AlbumDTO;
import com.ca.musiccore.dto.ArtistDTO;
import com.ca.musiccore.dto.GenreDTO;
import com.ca.musiccore.dto.SongDTO;



public class AllSongRegisteredEvent {

    private String id;
    private SongDTO song;
    private AlbumDTO album;
    private ArtistDTO artist;
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
