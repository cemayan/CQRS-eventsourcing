package com.ca.recocore.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class Genre {

    @Id
    private final String name;

    @Relationship(type = "RELATED_IN", direction = Relationship.Direction.INCOMING)
    private List<Song> songList;

    public Genre(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
