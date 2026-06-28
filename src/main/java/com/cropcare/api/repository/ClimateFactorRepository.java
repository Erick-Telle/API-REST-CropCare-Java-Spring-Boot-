package com.cropcare.api.repository;

import com.cropcare.api.entity.ClimateFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClimateFactorRepository extends JpaRepository<ClimateFactor, Long> {

    List<ClimateFactor> findByTipoFactorIgnoreCase(String tipoFactor);
}
