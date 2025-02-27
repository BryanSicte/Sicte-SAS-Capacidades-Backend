package com.sicte.capacidades.reporteMaterialFerretero.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "registros_reporte_material_ferretero")
@NoArgsConstructor
@AllArgsConstructor
public class ReporteMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String cedula;
    private String nombre;
    private String ot;
    private String codigoMovil;
    private String movil;
    private String responsable;
    private String nodo;
    private String codigoSap;
    private String descripcion;
    private String unidadMedida;
    private String cantidad;
    private String serial;
    private String firma;
}