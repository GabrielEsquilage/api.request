package com.eecplise.api.request.repository.fipe;


import com.eecplise.api.request.entity.fipe.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

}
