package com.eecplise.api.request.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeModelDTO {

    private Long id;

    @JsonProperty("fipe_code")
    private String fipeCode;

    private String model;

    private String years;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFipeCode() {
        return fipeCode;
    }

    public void setFipeCode(String fipeCode) {
        this.fipeCode = fipeCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}
