package com.ca.recoqueryservice.service;


import com.ca.recocore.models.Genre;
import reactor.core.publisher.Mono;

public interface RecommendationService {
    Mono<Genre> getReco(String name);
}
