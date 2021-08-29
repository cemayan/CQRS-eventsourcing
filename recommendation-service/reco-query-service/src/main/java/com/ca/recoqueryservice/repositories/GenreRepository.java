package com.ca.recoqueryservice.repositories;


import com.ca.recocore.models.Genre;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface GenreRepository extends ReactiveNeo4jRepository<Genre, String> {
    Mono<Genre> findOneByName(String name);
}
