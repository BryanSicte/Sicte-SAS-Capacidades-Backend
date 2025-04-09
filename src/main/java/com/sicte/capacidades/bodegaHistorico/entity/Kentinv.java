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
@Table(name = "kentinv")
@NoArgsConstructor
@AllArgsConstructor
public class Kentinv {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(name = "llave")
    private String llave;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "nrocompro_c")
    private String nrocomproC;
    @Column(name = "nrosolmat")
    private String nrosolmat;
    @Column(name = "producto")
    private String producto;
    @Column(name = "descrip")
    private String descrip;
    @Column(name = "unimed")
    private String unimed;
    @Column(name = "canrecib")
    private String canrecib;
    @Column(name = "conciliacion")
    private String conciliacion;
    @Column(name = "facturacion")
    private String facturacion;
    @Column(name = "bodres")
    private String bodres;
    @Column(name = "bodove")
    private String bodove;
    @Column(name = "bodaco")
    private String bodaco;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "Fecha descarga")
    private String fechaDescarga;
    @Column(name = "Bodega")
    private String bodega;
}