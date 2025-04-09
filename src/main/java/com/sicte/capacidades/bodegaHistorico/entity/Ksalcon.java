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
@Table(name = "ksalcon")
@NoArgsConstructor
@AllArgsConstructor
public class Ksalcon {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(name = "llave")
    private String llave;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "codconsumidor")
    private String codconsumidor;
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
    @Column(name = "codproyecto")
    private String codproyecto;
    @Column(name = "nroapoyo")
    private String nroapoyo;
    @Column(name = "observ")
    private String observ;
    @Column(name = "ind_instaladores")
    private String indInstaladores;
    @Column(name = "nom_recibe")
    private String nomRecibe;
    @Column(name = "hora_sal")
    private String horaSal;
    @Column(name = "x1")
    private String x1;
    @Column(name = "Fecha descarga")
    private String fechaDescarga;
    @Column(name = "Bodega")
    private String bodega;
}