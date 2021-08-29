package com.ca.recoqueryservice.dto;

import com.ca.recocore.dto.BaseResponse;
import com.ca.recocore.models.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RecommendationResponse  extends BaseResponse {
    private Genre genre;

    public RecommendationResponse(String message) {
        super(message);
    }

    public RecommendationResponse(String message, Genre genre) {
        super(message);
        this.genre = genre;
    }



    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
