package com.ca.recoqueryservice.controllers;


import com.ca.recoqueryservice.dto.RecommendationDTO;
import com.ca.recoqueryservice.dto.RecommendationResponse;
import com.ca.recoqueryservice.service.RecommendationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/recoLookup")
public class RecoLookupController {

    private final RecommendationServiceImpl recommendationService;


    public RecoLookupController(RecommendationServiceImpl recommendationService) {
        this.recommendationService = recommendationService;
    }


    @PostMapping("/")
    public Mono<ResponseEntity<RecommendationResponse>> getReco(@Valid @RequestBody RecommendationDTO recommendationDTO) {

        switch (recommendationDTO.getRecoType()) {
            case GENRE:
                return recommendationService.getReco(recommendationDTO.getValue())
                        .map(resp-> ResponseEntity.status(200).body(new RecommendationResponse("",resp)));
            default:
                break;
        }


        return Mono.just(ResponseEntity.status(400).body(new RecommendationResponse("Bad Request!")));
    }
}
