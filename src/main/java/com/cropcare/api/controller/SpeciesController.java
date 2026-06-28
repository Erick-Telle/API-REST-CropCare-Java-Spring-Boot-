package com.cropcare.api.controller;

import com.cropcare.api.dto.SpeciesRequestDTO;
import com.cropcare.api.dto.SpeciesResponseDTO;
import com.cropcare.api.service.SpeciesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/species")
@Tag(name = "Species", description = "Gestión del catálogo de especies de plantas")
public class SpeciesController {

    private final SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping
    @Operation(summary = "Listar todas las especies")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de especies obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<SpeciesResponseDTO>> findAll() {
        return ResponseEntity.ok(speciesService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una especie por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Especie encontrada"),
            @ApiResponse(responseCode = "404", description = "Especie no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<SpeciesResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(speciesService.findById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar especies por nombre común")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resultados de búsqueda obtenidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<SpeciesResponseDTO>> search(@RequestParam String nombre) {
        return ResponseEntity.ok(speciesService.searchByNombreComun(nombre));
    }

    @PostMapping
    @Operation(summary = "Crear una nueva especie")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Especie creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<SpeciesResponseDTO> create(@Valid @RequestBody SpeciesRequestDTO request) {
        SpeciesResponseDTO created = speciesService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una especie existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Especie actualizada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "Especie no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<SpeciesResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody SpeciesRequestDTO request) {
        return ResponseEntity.ok(speciesService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una especie")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Especie eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Especie no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        speciesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
