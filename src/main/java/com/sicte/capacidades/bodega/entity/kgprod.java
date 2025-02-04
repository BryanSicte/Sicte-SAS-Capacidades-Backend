package com.sicte.capacidades.bodega.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "kgprod")
@NoArgsConstructor
@AllArgsConstructor
public class kgprod {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descrip")
    private String descrip;
    @Column(name = "unimed")
    private String unimed;
    @Column(name = "serial")
    private String serial;
    @Column(name = "nvmin")
    private String nvmin;
    @Column(name = "candisp")
    private String candisp;
    @Column(name = "cantent")
    private String cantent;
    @Column(name = "cantres")
    private String cantres;
    @Column(name = "cantove")
    private String cantove;
    @Column(name = "movilres")
    private String movilres;
    @Column(name = "movilove")
    private String movilove;
    @Column(name = "movilman")
    private String movilman;
    @Column(name = "fchinvfis")
    private String fchinvfis;
    @Column(name = "bodres")
    private String bodres;
    @Column(name = "bodove")
    private String bodove;
    @Column(name = "cantaco")
    private String cantaco;
    @Column(name = "movilaco")
    private String movilaco;
    @Column(name = "bodaco")
    private String bodaco;
    @Column(name = "deltaifbo")
    private String deltaifbo;
    @Column(name = "deltaifmv")
    private String deltaifmv;
    @Column(name = "peps_de_bod")
    private String pepsDeBod;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "ind_instaladores")
    private String indInstaladores;
    @Column(name = "invfis")
    private String invfis;
    @Column(name = "lote_rollo_nada")
    private String loteRolloNada;
    @Column(name = "ind_comprado")
    private String indComprado;
    @Column(name = "Fecha descarga")
    private String fechaDescarga;
    @Column(name = "Bodega")
    private String bodega;
    @Column(name = "ind_comprado_2")
    private String indComprado2;
}