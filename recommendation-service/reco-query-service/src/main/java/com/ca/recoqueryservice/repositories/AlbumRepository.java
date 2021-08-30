package com.ca.recoqueryservice.repositories;


import com.ca.recocore.models.Album;
import com.ca.recocore.models.Artist;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends ReactiveNeo4jRepository<Album, String> {

}
