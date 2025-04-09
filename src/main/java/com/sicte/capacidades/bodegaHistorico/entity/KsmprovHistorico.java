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
@Table(name = "ksmprov")
@NoArgsConstructor
@AllArgsConstructor
public class KsmprovHistorico {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(name = "llave")
    private String llave;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "codproveedor")
    private String codproveedor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "producto")
    private String producto;
    @Column(name = "descrip")
    private String descrip;
    @Column(name = "unimed")
    private String unimed;
    @Column(name = "cantidad")
    private String cantidad;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fechau")
    private String fechau;
    @Column(name = "Fecha descarga")
    private String fechaDescarga;
    @Column(name = "Bodega")
    private String bodega;
}