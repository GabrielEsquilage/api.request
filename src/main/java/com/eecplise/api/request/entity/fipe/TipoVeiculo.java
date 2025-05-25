package com.eecplise.api.request.entity.fipe;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipos_veiculo", schema = "fipe")
public class TipoVeiculo {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "tipoVeiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Marca> marcas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }
}


