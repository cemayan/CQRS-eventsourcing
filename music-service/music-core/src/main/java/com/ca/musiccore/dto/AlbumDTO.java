package com.ca.musiccore.dto;

import com.ca.musiccore.enumaration.Genre;
import com.ca.musiccore.models.Artist;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class AlbumDTO {

    private String id;
    private String name;

    private String recordLabel;
    private Integer year;

    private ZonedDateTime releaseDate;
    private Genre genre;

    private String artistId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public ZonedDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(ZonedDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
}
