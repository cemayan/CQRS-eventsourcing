package com.ca.musiccore.models;


import com.ca.musiccore.enumaration.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;


@Table("albums")
public class Album implements Persistable {

    @Id
    private String id;

    private String name;
    private String recordLabel;
    private Integer year;
    private ZonedDateTime releaseDate;



    @Transient
    private boolean newAlbum;

    @Version
    private Long version = 0L;

    @Transient
    public boolean isNew() {
        return this.newAlbum || id == null;
    }

    public Album setAsNew() {
        this.newAlbum = true;
        return this;
    }

    @Column("artist_id")
    @JsonProperty("artistId")
    private String artistId;


    @Override
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

    public boolean isNewAlbum() {
        return newAlbum;
    }

    public void setNewAlbum(boolean newAlbum) {
        this.newAlbum = newAlbum;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
}
