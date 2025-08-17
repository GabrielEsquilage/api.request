package com.eecplise.api.request.repository.fipe;


import com.eecplise.api.request.entity.fipe.Marca;
import com.eecplise.api.request.entity.fipe.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByMarca(Marca marca);
    List<Model> findByModelContainingIgnoreCase(String termo);

}
