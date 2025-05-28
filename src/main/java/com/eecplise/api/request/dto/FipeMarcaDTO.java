package com.eecplise.api.request.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeMarcaDTO {

    @JsonProperty("id")
    private String codigo;

    @JsonProperty("brand")
    private String nome;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
