package com.cropcare.api.dto;

import java.time.LocalDateTime;

public class SpeciesResponseDTO {

    private Long id;
    private String nombreComun;
    private String nombreCientifico;
    private Integer frecuenciaBaseDias;
    private Integer cantidadBaseAguaMl;
    private Float ajustePorTemperatura;
    private Float ajustePorHumedad;
    private String consejosLuz;
    private String consejosHumedad;
    private String consejosAbono;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public Integer getFrecuenciaBaseDias() {
        return frecuenciaBaseDias;
    }

    public void setFrecuenciaBaseDias(Integer frecuenciaBaseDias) {
        this.frecuenciaBaseDias = frecuenciaBaseDias;
    }

    public Integer getCantidadBaseAguaMl() {
        return cantidadBaseAguaMl;
    }

    public void setCantidadBaseAguaMl(Integer cantidadBaseAguaMl) {
        this.cantidadBaseAguaMl = cantidadBaseAguaMl;
    }

    public Float getAjustePorTemperatura() {
        return ajustePorTemperatura;
    }

    public void setAjustePorTemperatura(Float ajustePorTemperatura) {
        this.ajustePorTemperatura = ajustePorTemperatura;
    }

    public Float getAjustePorHumedad() {
        return ajustePorHumedad;
    }

    public void setAjustePorHumedad(Float ajustePorHumedad) {
        this.ajustePorHumedad = ajustePorHumedad;
    }

    public String getConsejosLuz() {
        return consejosLuz;
    }

    public void setConsejosLuz(String consejosLuz) {
        this.consejosLuz = consejosLuz;
    }

    public String getConsejosHumedad() {
        return consejosHumedad;
    }

    public void setConsejosHumedad(String consejosHumedad) {
        this.consejosHumedad = consejosHumedad;
    }

    public String getConsejosAbono() {
        return consejosAbono;
    }

    public void setConsejosAbono(String consejosAbono) {
        this.consejosAbono = consejosAbono;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
