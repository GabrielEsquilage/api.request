package com.eecplise.api.request.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class FipeAnosResponseDTO {

    private String brand;
    private String model;
    private String reference;

    @JsonProperty("years")
    private List<FipeAnoPrecoDTO> anos;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<FipeAnoPrecoDTO> getAnos() {
        return anos;
    }

    public void setAnos(List<FipeAnoPrecoDTO> anos) {
        this.anos = anos;
    }
}

