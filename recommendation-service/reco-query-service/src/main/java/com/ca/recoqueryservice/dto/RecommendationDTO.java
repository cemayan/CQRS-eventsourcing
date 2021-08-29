package com.ca.recoqueryservice.dto;

import com.ca.recocore.enumaration.RecoType;

import javax.validation.Valid;

public class RecommendationDTO {

    @Valid
    private RecoType recoType;

    @Valid
    private String value;

    public RecoType getRecoType() {
        return recoType;
    }

    public void setRecoType(RecoType recoType) {
        this.recoType = recoType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
