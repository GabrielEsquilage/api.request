package com.eecplise.api.request.entity.fipe;

import jakarta.persistence.*;

@Entity
@Table(name = "models", schema = "fipe")
public class Model {

    @Id
    private Long id;

    @Column(name = "fipe_code", nullable = false)
    private String fipeCode;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String years;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    

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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
