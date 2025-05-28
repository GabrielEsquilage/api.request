package com.eecplise.api.request.repository.fipe;

import com.eecplise.api.request.entity.fipe.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Optional<Marca> findByCodigoAndTipoVeiculo_Id(String codigo, Integer idTipoVeiculo);
}
