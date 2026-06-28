package com.cropcare.api.service;

import com.cropcare.api.dto.SpeciesRequestDTO;
import com.cropcare.api.dto.SpeciesResponseDTO;
import com.cropcare.api.entity.Species;
import com.cropcare.api.exception.ResourceNotFoundException;
import com.cropcare.api.mapper.SpeciesMapper;
import com.cropcare.api.repository.SpeciesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpeciesService {

    private final SpeciesRepository speciesRepository;
    private final SpeciesMapper speciesMapper;

    public SpeciesService(SpeciesRepository speciesRepository, SpeciesMapper speciesMapper) {
        this.speciesRepository = speciesRepository;
        this.speciesMapper = speciesMapper;
    }

    @Transactional(readOnly = true)
    public List<SpeciesResponseDTO> findAll() {
        return speciesRepository.findAll().stream()
                .map(speciesMapper::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public SpeciesResponseDTO findById(Long id) {
        Species species = speciesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontró la especie con id: " + id));
        return speciesMapper.toResponseDTO(species);
    }

    @Transactional(readOnly = true)
    public List<SpeciesResponseDTO> searchByNombreComun(String nombre) {
        return speciesRepository.findByNombreComunContainingIgnoreCase(nombre).stream()
                .map(speciesMapper::toResponseDTO)
                .toList();
    }

    public SpeciesResponseDTO create(SpeciesRequestDTO request) {
        validateUniqueNombreCientifico(request.getNombreCientifico(), null);
        Species species = speciesMapper.toEntity(request);
        Species saved = speciesRepository.save(species);
        return speciesMapper.toResponseDTO(saved);
    }

    public SpeciesResponseDTO update(Long id, SpeciesRequestDTO request) {
        Species species = speciesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontró la especie con id: " + id));
        validateUniqueNombreCientifico(request.getNombreCientifico(), id);
        speciesMapper.updateEntityFromDTO(species, request);
        Species updated = speciesRepository.save(species);
        return speciesMapper.toResponseDTO(updated);
    }

    public void delete(Long id) {
        if (!speciesRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró la especie con id: " + id);
        }
        speciesRepository.deleteById(id);
    }

    private void validateUniqueNombreCientifico(String nombreCientifico, Long excludeId) {
        boolean exists = excludeId == null
                ? speciesRepository.existsByNombreCientificoIgnoreCase(nombreCientifico)
                : speciesRepository.existsByNombreCientificoIgnoreCaseAndIdNot(nombreCientifico, excludeId);
        if (exists) {
            throw new IllegalArgumentException(
                    "Ya existe una especie con el nombre científico: " + nombreCientifico);
        }
    }
}
