package com.ca.musiccore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Album {


    private String id;

    private String name;
//
//    @OneToMany
//    private List<Song> songs;

}
