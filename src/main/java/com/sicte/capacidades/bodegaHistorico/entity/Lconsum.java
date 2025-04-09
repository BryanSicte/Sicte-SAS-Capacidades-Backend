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
@Table(name = "lconsum")
@NoArgsConstructor
@AllArgsConstructor
public class Lconsum {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(name = "llave")
    private String llave;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo_consumidor")
    private String tipoConsumidor;
    @Column(name = "fechasal")
    private String fechasal;
    @Column(name = "estadosal")
    private String estadosal;
    @Column(name = "encursosal")
    private String encursosal;
    @Column(name = "responsable")
    private String responsable;
    @Column(name = "ind_borrado")
    private String indBorrado;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "llave.1")
    private String llave1;
    @Column(name = "supervisor")
    private String supervisor;
    @Column(name = "fch_control")
    private String fchControl;
    @Column(name = "nombre_c")
    private String nombreC;
    @Column(name = "doc_ident")
    private String docIdent;
    @Column(name = "cod_cuadrxdef")
    private String codCuadrxdef;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fechau")
    private String fechau;
    @Column(name = "usuariom")
    private String usuariom;
    @Column(name = "fechaum")
    private String fechaum;
    @Column(name = "tipo_movil")
    private String tipoMovil;
    @Column(name = "controlado_nomina")
    private String controladoNomina;
    @Column(name = "Fecha descarga")
    private String fechaDescarga;
    @Column(name = "Bodega")
    private String bodega;
}