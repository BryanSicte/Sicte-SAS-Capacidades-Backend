package com.sicte.capacidades.chatbot.entity;

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
@Table(name = "registros_chatbot")
@NoArgsConstructor
@AllArgsConstructor
public class Chatbot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registro;
    private String fuente;
    private String stage;
    private String celularChat;
    private String aceptoPolitica;
    private String nombreApellido;
    private String celular;
    private String ciudad;
    private String cargo;
    private String detalleCargo;
    private String respuestaFiltro1;
    private String respuestaFiltro2;
    private String respuestaFiltro3;
    private String direccion;
    private String fechaHora;
    private String estadoFinal;
    private String observaciones;
    private String fechaHoraInicial;
    private String asistencia;
    private String seleccion;
    private String examenesMedicos;
    private String contratacion;
    private String estadoContratacion;
}