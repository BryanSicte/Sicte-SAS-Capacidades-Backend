package com.sicte.capacidades.capacidad.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "movil")
@NoArgsConstructor
@AllArgsConstructor
public class Movil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "tipo movil")
    private String tipoMovil;
    @Column(name = "tipo facturacion")
    private String tipoFacturacion;
    @Column(name = "turnos")
    private String turnos;
    @Column(name = "personas")
    private String personas;
    @Column(name = "movil")
    private String movil;
    @Column(name = "valor esperado")
    private String valorEsperado;
}