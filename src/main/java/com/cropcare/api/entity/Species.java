package com.cropcare.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "species")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombreComun;

    @Column(nullable = false, length = 150, unique = true)
    private String nombreCientifico;

    @Column(nullable = false)
    private Integer frecuenciaBaseDias;

    @Column(nullable = false)
    private Integer cantidadBaseAguaMl;

    @Column(nullable = false)
    private Float ajustePorTemperatura;

    @Column(nullable = false)
    private Float ajustePorHumedad;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String consejosLuz;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String consejosHumedad;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String consejosAbono;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        fechaCreacion = now;
        fechaActualizacion = now;
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }

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
