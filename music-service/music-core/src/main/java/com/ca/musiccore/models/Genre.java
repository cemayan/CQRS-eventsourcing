package com.ca.musiccore.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;


@Table("genres")
public class Genre implements Persistable {

    @Id
    private Long id;
    private String name;

    @Transient
    private boolean newGenre;

    @Version
    private Long version = 0L;

    @Override
    public Object getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }


    public Genre setAsNew() {
        this.newGenre = true;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNewGenre() {
        return newGenre;
    }

    public void setNewGenre(boolean newGenre) {
        this.newGenre = newGenre;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
