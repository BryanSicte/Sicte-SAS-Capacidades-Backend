package com.sicte.capacidades.capacidad.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AgregarPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String cedula;
    private String carpeta;
    private String placa;
    private String tipoFacturacion;
    private String tipoMovil;
    private String coordinador;
}