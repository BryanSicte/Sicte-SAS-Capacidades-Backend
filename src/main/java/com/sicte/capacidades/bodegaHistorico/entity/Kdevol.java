package com.sicte.capacidades.bodegaHistorico.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "kdevol")
@NoArgsConstructor
@AllArgsConstructor
public class Kdevol {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(name = "llave")
    private String llave;
    @Column(name = "Fecha")
    private String fecha;
    @Column(name = "Cod consumidor")
    private String codConsumidor;
    @Column(name = "Nombre consumidor")
    private String nombreConsumidor;
    @Column(name = "Producto")
    private String producto;
    @Column(name = "Descripción")
    private String descripcion;
    @Column(name = "U.M.")
    private String um;
    @Column(name = "Cantidad")
    private String cantidad;
    @Column(name = "Proyecto")
    private String proyecto;
    @Column(name = "Observación")
    private String observacion;
    @Column(name = "Fecha descarga")
    private String fechaDescarga;
    @Column(name = "Bodega")
    private String bodega;
}