package com.ca.musicqueryapi.repositories;


import com.ca.musiccore.models.Album;
import com.ca.musiccore.models.Song;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends R2dbcRepository<Album, String> {
}
