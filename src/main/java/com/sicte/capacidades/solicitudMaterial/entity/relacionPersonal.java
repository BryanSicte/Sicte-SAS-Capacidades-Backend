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
@Table(name = "relacion_personal")
@NoArgsConstructor
@AllArgsConstructor
public class RelacionPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String director;
    private String coordinador;
    private String direccion;
    private String supervisor;
    private String bodega;
    private String ciudad;
    private String analistaLogistica;
    private String supervisorLogistica;
    private String facturacion;
}