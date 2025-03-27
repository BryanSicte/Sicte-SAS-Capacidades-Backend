package com.sicte.capacidades.carnetizacion.entity;

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
@Table(name = "registros_carnetizacion")
@NoArgsConstructor
@AllArgsConstructor
public class Carnetizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registro;
    private String cedulaSupervisor;
    private String nombreSupervisor;
    private String cedulaTecnico;
    private String nombreTecnico;
    private String tipoCarnet;
    private String solicitud;
    private String foto;
    private String segmento;
    private String estado;
}