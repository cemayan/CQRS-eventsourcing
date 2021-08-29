package com.ca.musicqueryapi.repositories;


import com.ca.musiccore.models.Artist;
import com.ca.musiccore.models.Genre;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends R2dbcRepository<Artist, String> {
}
