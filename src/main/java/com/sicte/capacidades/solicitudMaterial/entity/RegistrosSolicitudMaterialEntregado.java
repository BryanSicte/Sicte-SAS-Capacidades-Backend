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
@Table(name = "registros_solicitud_materiales_entregado")
@NoArgsConstructor
@AllArgsConstructor
public class RegistrosSolicitudMaterialEntregado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fechaEntrega;
    private String ciudad;
    private String documento;
    private String uuid;
    private String nombreProyecto;
    private String codigoSapMaterial;
    private String descripcionMaterial;
    private String unidadMedidaMaterial;
    private String cantidadSolicitadaMaterial;
    private String material;
}