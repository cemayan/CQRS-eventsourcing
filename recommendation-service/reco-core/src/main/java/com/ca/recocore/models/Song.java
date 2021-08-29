package com.ca.recocore.models;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class Song {

    @Id @GeneratedValue
    private Long id;

    private final String name;

    public Song(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
