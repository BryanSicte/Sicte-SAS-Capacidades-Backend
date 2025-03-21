package com.sicte.capacidades.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ActualizarDatos {
    private Long id;
    private String cargo;
    private String fechaHora;
    private String estadoFinal;
    private String observaciones;
    private String fechaHoraInicial;
    private String asistencia;
    private String seleccion;
    private String examenesMedicos;
    private String contratacion;
    private String estadoContratacion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaHoraInicial() {
        return fechaHoraInicial;
    }

    public void setFechaHoraInicial(String fechaHoraInicial) {
        this.fechaHoraInicial = fechaHoraInicial;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

    public String getExamenesMedicos() {
        return examenesMedicos;
    }

    public void setExamenesMedicos(String examenesMedicos) {
        this.examenesMedicos = examenesMedicos;
    }

    public String getContratacion() {
        return contratacion;
    }

    public void setContratacion(String contratacion) {
        this.contratacion = contratacion;
    }

    public String getEstadoContratacion() {
        return estadoContratacion;
    }

    public void setEstadoContratacion(String estadoContratacion) {
        this.estadoContratacion = estadoContratacion;
    }

}
