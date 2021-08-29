package com.ca.musicqueryapi.repositories;


import com.ca.musiccore.models.Album;
import com.ca.musiccore.models.Genre;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends R2dbcRepository<Genre, String> {
}
