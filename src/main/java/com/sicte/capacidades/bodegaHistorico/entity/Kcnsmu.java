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
@Table(name = "kcnsmu")
@NoArgsConstructor
@AllArgsConstructor
public class Kcnsmu {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(name = "Cuenta")
    private String cuenta;
    @Column(name = "OT")
    private String ot;
    @Column(name = "Nodo")
    private String nodo;
    @Column(name = "Fecha")
    private String fecha;
    @Column(name = "Actividad")
    private String actividad;
    @Column(name = "Producto")
    private String producto;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Cantidad")
    private String cantidad;
    @Column(name = "CeCo")
    private String ceCo;
    @Column(name = "Cod. subcon")
    private String codSubcon;
    @Column(name = "Movil")
    private String movil;
    @Column(name = "Nro trabajos")
    private String nroTrabajos;
    @Column(name = "OIM")
    private String oim;
    @Column(name = "Nro consumo")
    private String nroConsumo;
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "Cod familia")
    private String codFamilia;
    @Column(name = "Descrip. familia")
    private String descripFamilia;
    @Column(name = "Descrip. actividad")
    private String descripActividad;
    @Column(name = "Cod trabajo")
    private String codTrabajo;
    @Column(name = "Desc. trabajo")
    private String descTrabajo;
    @Column(name = "Aviso")
    private String aviso;
    @Column(name = "Fecha reporte")
    private String fechaReporte;
    @Column(name = "U.M.")
    private String um;
    @Column(name = "Técnico")
    private String tecnico;
    @Column(name = "Fechau")
    private String fechau;
    @Column(name = "Cod. consum")
    private String codConsum;
    @Column(name = "Complemento")
    private String complemento;
    @Column(name = "Fecha descarga")
    private String fechaDescarga;
    @Column(name = "Bodega")
    private String bodega;
}