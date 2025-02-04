package com.sicte.capacidades.capacidad.entity;

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
@Table(name = "coordinador")
@NoArgsConstructor
@AllArgsConstructor
public class coordinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "coordinador")
    private String coordinador;
    @Column(name = "director")
    private String director;
    @Column(name = "red")
    private String red;
    @Column(name = "area")
    private String area;
    @Column(name = "subarea")
    private String subarea;
    @Column(name = "cliente")
    private String cliente;
}