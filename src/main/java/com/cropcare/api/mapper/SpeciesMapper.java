package com.cropcare.api.mapper;

import com.cropcare.api.dto.SpeciesRequestDTO;
import com.cropcare.api.dto.SpeciesResponseDTO;
import com.cropcare.api.entity.Species;
import org.springframework.stereotype.Component;

@Component
public class SpeciesMapper {

    public SpeciesResponseDTO toResponseDTO(Species species) {
        SpeciesResponseDTO dto = new SpeciesResponseDTO();
        dto.setId(species.getId());
        dto.setNombreComun(species.getNombreComun());
        dto.setNombreCientifico(species.getNombreCientifico());
        dto.setFrecuenciaBaseDias(species.getFrecuenciaBaseDias());
        dto.setCantidadBaseAguaMl(species.getCantidadBaseAguaMl());
        dto.setAjustePorTemperatura(species.getAjustePorTemperatura());
        dto.setAjustePorHumedad(species.getAjustePorHumedad());
        dto.setConsejosLuz(species.getConsejosLuz());
        dto.setConsejosHumedad(species.getConsejosHumedad());
        dto.setConsejosAbono(species.getConsejosAbono());
        dto.setFechaCreacion(species.getFechaCreacion());
        dto.setFechaActualizacion(species.getFechaActualizacion());
        return dto;
    }

    public Species toEntity(SpeciesRequestDTO dto) {
        Species species = new Species();
        updateEntityFromDTO(species, dto);
        return species;
    }

    public void updateEntityFromDTO(Species species, SpeciesRequestDTO dto) {
        species.setNombreComun(dto.getNombreComun());
        species.setNombreCientifico(dto.getNombreCientifico());
        species.setFrecuenciaBaseDias(dto.getFrecuenciaBaseDias());
        species.setCantidadBaseAguaMl(dto.getCantidadBaseAguaMl());
        species.setAjustePorTemperatura(dto.getAjustePorTemperatura());
        species.setAjustePorHumedad(dto.getAjustePorHumedad());
        species.setConsejosLuz(dto.getConsejosLuz());
        species.setConsejosHumedad(dto.getConsejosHumedad());
        species.setConsejosAbono(dto.getConsejosAbono());
    }
}
