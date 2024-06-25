package com.sicte.capacidades.capacidad.Entity;

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
@Table(name = "planta")
@NoArgsConstructor
@AllArgsConstructor
public class Planta {
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
    @Column(name = "FECHA DE NACIMIENTO")
    private String fechaNacimiento;
    @Column(name = "PENSION")
    private String pension;
    @Column(name = "SALUD")
    private String salud;
    @Column(name = "CESANTIAS")
    private String cesantias;
    @Column(name = "CAJA")
    private String caja;
    @Column(name = "TIPO CONTRATO")
    private String tipoContrato;
    @Column(name = "PERFIL")
    private String perfil;
    @Column(name = "ANALISTA")
    private String analista;
    @Column(name = "DIRECTOR")
    private String director;
}