package com.ca.recocore.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Node
public class Genre {

    @Id
    private String id;
    private final String name;



    @Relationship(type = "RELATED_IN", direction = Relationship.Direction.INCOMING)
    private Set<Song> songList = new HashSet<>();

    public Genre(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Set<Song> getSongList() {
        return songList;
    }

    public void setSongList(Set<Song> songList) {
        this.songList = songList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addRelation(Song song) {
        this.songList.add(song);
    }

}
