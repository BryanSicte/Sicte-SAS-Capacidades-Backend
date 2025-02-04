package com.sicte.capacidades.capacidad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "capacidades")
@NoArgsConstructor
@AllArgsConstructor
public class capacidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CEDULA", unique = true)
    private String cedula;
    @Column(name = "NOMBRE COMPLETO")
    private String nombreCompleto;
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "CENTRO COSTO")
    private String centroCosto;
    @Column(name = "NOMINA")
    private String nomina;
    @Column(name = "REGIONAL")
    private String regional;
    @Column(name = "CIUDAD TRABAJO")
    private String ciudadTrabajo;
    @Column(name = "RED")
    private String red;
    @Column(name = "CLIENTE")
    private String cliente;
    @Column(name = "ÁREA")
    private String area;
    @Column(name = "SUB-AREA")
    private String subArea;
    @Column(name = "CÓDIGO SAP")
    private String codigoSap;
    @Column(name = "TIPO DE MOVIL")
    private String tipoDeMovil;
    @Column(name = "TIPO FACTURACIÓN")
    private String tipoFacturacion;
    @Column(name = "MOVIL")
    private String movil;
    @Column(name = "COORDINADOR")
    private String coordinador;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "CONTRATISTA")
    private String contratista;
    @Column(name = "VALOR ESPERADO")
    private String valorEsperado;
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "TIPO CARRO")
    private String tipoCarro;
    @Column(name = "FECHA REPORTE")
    private String fechaReporte;
    @Column(name = "MES")
    private String mes;
    @Column(name = "AÑO")
    private String año;
    @Column(name = "TURNOS")
    private String turnos;
    @Column(name = "PERSONAS")
    private String personas;
    @Column(name = "CARPETA")
    private String carpeta;
}