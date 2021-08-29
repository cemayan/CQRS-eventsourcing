package com.ca.recoqueryservice.service;


import com.ca.recocore.models.Genre;
import com.ca.recoqueryservice.repositories.GenreRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final GenreRepository genreRepository;

    public RecommendationServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Mono<Genre> getReco(String name) {
        return genreRepository.findOneByName(name);
    }
}
