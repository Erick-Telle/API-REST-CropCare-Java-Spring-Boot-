package com.cropcare.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SpeciesRequestDTO {

    @NotBlank(message = "El nombre común es obligatorio")
    @Size(max = 100, message = "El nombre común no puede superar 100 caracteres")
    private String nombreComun;

    @NotBlank(message = "El nombre científico es obligatorio")
    @Size(max = 150, message = "El nombre científico no puede superar 150 caracteres")
    private String nombreCientifico;

    @NotNull(message = "La frecuencia base en días es obligatoria")
    @Min(value = 1, message = "La frecuencia base debe ser mayor a 0")
    private Integer frecuenciaBaseDias;

    @NotNull(message = "La cantidad base de agua es obligatoria")
    @Min(value = 1, message = "La cantidad base de agua debe ser mayor a 0")
    private Integer cantidadBaseAguaMl;

    @NotNull(message = "El ajuste por temperatura es obligatorio")
    private Float ajustePorTemperatura;

    @NotNull(message = "El ajuste por humedad es obligatorio")
    private Float ajustePorHumedad;

    @NotBlank(message = "Los consejos de luz son obligatorios")
    private String consejosLuz;

    @NotBlank(message = "Los consejos de humedad son obligatorios")
    private String consejosHumedad;

    @NotBlank(message = "Los consejos de abono son obligatorios")
    private String consejosAbono;

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
}
