package com.sicte.capacidades.inventarioMaterial.entity;

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
@Table(name = "registros_inventario_materiales")
@NoArgsConstructor
@AllArgsConstructor
public class InventarioMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String cedula;
    private String nombre;
    private String codigoMovil;
    private String movil;
    private String responsable;
    private String codigoSap;
    private String descripcion;
    private String unidadMedida;
    private String cantidad;
    private String serial;
}