package com.eecplise.api.request.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeAnoPrecoDTO {

    @JsonProperty("year_id")
    private String yearId;

    @JsonProperty("model_year")
    private String modelYear;

    private String fuel;

    private Integer price;

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
