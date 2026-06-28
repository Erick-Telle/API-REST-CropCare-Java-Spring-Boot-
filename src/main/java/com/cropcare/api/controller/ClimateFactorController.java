package com.cropcare.api.controller;

import com.cropcare.api.dto.ClimateFactorResponseDTO;
import com.cropcare.api.service.ClimateFactorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/climate-factors")
@Tag(name = "Climate Factors", description = "Factores de ajuste climático para el riego")
public class ClimateFactorController {

    private final ClimateFactorService climateFactorService;

    public ClimateFactorController(ClimateFactorService climateFactorService) {
        this.climateFactorService = climateFactorService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los factores climáticos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de factores obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<ClimateFactorResponseDTO>> findAll() {
        return ResponseEntity.ok(climateFactorService.findAll());
    }

    @GetMapping("/tipo/{tipoFactor}")
    @Operation(summary = "Filtrar factores por tipo (TEMPERATURA, HUMEDAD, ESTACION)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Factores filtrados obtenidos correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<ClimateFactorResponseDTO>> findByTipo(@PathVariable String tipoFactor) {
        return ResponseEntity.ok(climateFactorService.findByTipoFactor(tipoFactor));
    }
}
