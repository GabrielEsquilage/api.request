package com.eecplise.api.request.dto;

public class FipeCodeResponseDTO {
    private String id;
    private String fipe_code;
    private String model;
    private String year;

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFipe_code() {
        return fipe_code;
    }

    public void setFipe_code(String fipe_code) {
        this.fipe_code = fipe_code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
