package com.ca.musiccore.models;

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

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("songs")
public class Song  implements Persistable {

    @Id
    private String id;

    private String name;
    private String duration;
    private String image;
    private String lyrics;

    @Transient
    private boolean newSong;

    @Version
    private Long version = 0L;

    @Column("spotifyLink")
    private String spotifyLink;

    @Column("spotifyLink")
    private String youtubeLink;

    @Transient
    public boolean isNew() {
        return this.newSong || id == null;
    }

    public Song setAsNew() {
        this.newSong = true;
        return this;
    }

//    @OneToOne
//    private Album album;
//
//    @OneToOne
//    private Artist artist;
}
