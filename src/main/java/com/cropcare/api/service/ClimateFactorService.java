package com.cropcare.api.service;

import com.cropcare.api.dto.ClimateFactorResponseDTO;
import com.cropcare.api.entity.ClimateFactor;
import com.cropcare.api.repository.ClimateFactorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClimateFactorService {

    private final ClimateFactorRepository climateFactorRepository;

    public ClimateFactorService(ClimateFactorRepository climateFactorRepository) {
        this.climateFactorRepository = climateFactorRepository;
    }

    public List<ClimateFactorResponseDTO> findAll() {
        return climateFactorRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public List<ClimateFactorResponseDTO> findByTipoFactor(String tipoFactor) {
        return climateFactorRepository.findByTipoFactorIgnoreCase(tipoFactor).stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private ClimateFactorResponseDTO toResponseDTO(ClimateFactor factor) {
        ClimateFactorResponseDTO dto = new ClimateFactorResponseDTO();
        dto.setId(factor.getId());
        dto.setTipoFactor(factor.getTipoFactor());
        dto.setValorCondicion(factor.getValorCondicion());
        dto.setMultiplicador(factor.getMultiplicador());
        dto.setDescripcion(factor.getDescripcion());
        return dto;
    }
}
