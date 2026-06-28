package com.cropcare.api.repository;

import com.cropcare.api.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

    List<Species> findByNombreComunContainingIgnoreCase(String nombre);

    Optional<Species> findByNombreCientificoIgnoreCase(String nombreCientifico);

    boolean existsByNombreCientificoIgnoreCase(String nombreCientifico);

    boolean existsByNombreCientificoIgnoreCaseAndIdNot(String nombreCientifico, Long id);
}
