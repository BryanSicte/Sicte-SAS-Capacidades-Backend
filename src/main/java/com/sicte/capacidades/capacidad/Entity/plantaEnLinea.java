package com.sicte.capacidades.capacidad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "plantaenlinea")
@NoArgsConstructor
@AllArgsConstructor
public class plantaEnLinea {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "NIT")
    private String nit;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "F. INGRESO")
    private String fechaIngreso;
    @Column(name = "CC")
    private String cc;
    @Column(name = "SCC")
    private String scc;
    @Column(name = "F. RETIRO")
    private String fechaRetiro;
    @Column(name = "F. NACIMIE")
    private String fechaNacimiento;
    @Column(name = "TIPO CONTRATO")
    private String tipoContrato;
    @Column(name = "PERFIL")
    private String perfil;
}