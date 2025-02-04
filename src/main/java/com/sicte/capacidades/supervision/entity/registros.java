package com.sicte.capacidades.supervision.entity;

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
@Table(name = "registros_supervision")
@NoArgsConstructor
@AllArgsConstructor
public class registros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String nombre;
    private String placa;
    @Column(name = "cedula_cuadrilla")
    private String cedulaCuadrilla;
    @Column(name = "nombre_cuadrilla")
    private String nombreCuadrilla;
    private String ot;
    private String epp;
    @Column(name = "epp_comentario")
    private String eppComentario;
    private String alturas;
    @Column(name = "alturas_comentario")
    private String alturasComentario;
    private String ats;
    @Column(name = "ats_comentario")
    private String atsComentario;
    private String empalmes;
    @Column(name = "empalmes_comentario")
    private String empalmesComentario;
    private String preoperacional;
    @Column(name = "preoperacional_comentario")
    private String preoperacionalComentario;
    private String vehiculo;
    @Column(name = "vehiculo_comentario")
    private String vehiculoComentario;
    private String empalmadora;
    private String otdr;
    private String cortadora;
    private String pinza;
    private String opm;
    private String onexpert;
    @Column(name = "medidor_conductancia")
    private String medidorConductancia;
    @Column(name = "medidor_fugas")
    private String medidorFugas;
    private String observacion;
    @Column(name = "foto_nombre")
    private String fotoNombre;
    private String latitud;
    private String longitud;
}