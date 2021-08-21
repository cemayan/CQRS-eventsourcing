package com.ca.musicqueryapi.repositories;


import com.ca.musiccore.models.Song;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends R2dbcRepository<Song, String> {
}
