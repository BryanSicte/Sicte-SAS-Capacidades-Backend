package com.sicte.capacidades.solicitudMaterial.entity;

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
@Table(name = "registros_solicitud_materiales")
@NoArgsConstructor
@AllArgsConstructor
public class registrosSolicitudMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String cedula;
    private String nombre;
    private String ciudad;
    private String diseño;
    private String kmz;
    private String uuid;
    private String nombreProyecto;
    private String entregaProyecto;
    private String propiedadMaterial;
    private String codigoSapMaterial;
    private String descripcionMaterial;
    private String unidadMedidaMaterial;
    private String cantidadDisponibleMaterial;
    private String cantidadSolicitadaMaterial;
    private String cantidadRestantePorDespacho;
    private String aprobacionAnalista;
    private String fechaAnalista;
    private String observacionesAnalista;
    private String aprobacionDirector;
    private String fechaDirector;
    private String observacionesDirector;
    private String aprobacionDireccionOperacion;
    private String fechaDireccionOperacion;
    private String observacionesDireccionOperacion;
    private String entregaBodega;
    private String observacionesEntregaBodega;
    private String pdfs;
    private String estadoProyecto;
}