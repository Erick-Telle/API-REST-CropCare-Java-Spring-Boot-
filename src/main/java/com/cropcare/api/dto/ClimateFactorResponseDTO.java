package com.cropcare.api.dto;

public class ClimateFactorResponseDTO {

    private Long id;
    private String tipoFactor;
    private String valorCondicion;
    private Float multiplicador;
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoFactor() {
        return tipoFactor;
    }

    public void setTipoFactor(String tipoFactor) {
        this.tipoFactor = tipoFactor;
    }

    public String getValorCondicion() {
        return valorCondicion;
    }

    public void setValorCondicion(String valorCondicion) {
        this.valorCondicion = valorCondicion;
    }

    public Float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(Float multiplicador) {
        this.multiplicador = multiplicador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
