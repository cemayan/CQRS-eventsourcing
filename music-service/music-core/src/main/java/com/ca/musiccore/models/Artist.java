package com.ca.musiccore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("artists")
public class Artist implements Persistable {

    @Id
    private String id;
    private String name;

    @Transient
    private boolean newSong;

    @Version
    private Long version = 0L;


    @Transient
    public boolean isNew() {
        return this.newSong || id == null;
    }

    public Artist setAsNew() {
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
}
