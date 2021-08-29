package com.ca.musiccore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;




@Table("songs")
public class Song  implements Persistable {

    @Id
    private String id;

    private String name;
    private String duration;
    private String image;
    private String lyrics;

    @Column("album_id")
    @JsonProperty("albumId")
    private String albumId;

    @Transient
    private boolean newSong;

    @Version
    private Long version = 0L;

    @Column("spotifyLink")
    private String spotifyLink;

    @Column("youtubeLink")
    private String youtubeLink;

    @Column("genre_id")
    @JsonProperty("genreId")
    private String genreId;

    @Column("artist_id")
    @JsonProperty("artistId")
    private String artistId;



    @Transient
    public boolean isNew() {
        return this.newSong || id == null;
    }

    public Song setAsNew() {
        this.newSong = true;
        return this;
    }


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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public boolean isNewSong() {
        return newSong;
    }

    public void setNewSong(boolean newSong) {
        this.newSong = newSong;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getSpotifyLink() {
        return spotifyLink;
    }

    public void setSpotifyLink(String spotifyLink) {
        this.spotifyLink = spotifyLink;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }


    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
}
