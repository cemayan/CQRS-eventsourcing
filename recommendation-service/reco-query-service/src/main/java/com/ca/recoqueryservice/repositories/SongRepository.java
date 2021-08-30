package com.ca.recoqueryservice.repositories;


import com.ca.recocore.models.Genre;
import com.ca.recocore.models.Song;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SongRepository extends ReactiveNeo4jRepository<Song, String> {

}
