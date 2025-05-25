package com.eecplise.api.request.repository.fipe;

import com.eecplise.api.request.entity.fipe.TipoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoVeiculoRepository extends JpaRepository<TipoVeiculo, Integer> {
}

