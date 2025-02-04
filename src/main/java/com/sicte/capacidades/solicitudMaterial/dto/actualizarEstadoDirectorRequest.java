package com.sicte.capacidades.solicitudMaterial.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class actualizarEstadoDirectorRequest {
    private List<Long> ids;
    private String estado;
    private String observacionesTemporal;
    private String fechaRegistro;

    // Getters y setters
    public List<Long> getIds() {
        return ids;
    }
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observacionesTemporal;
    }
    public void setObservaciones(String observaciones) {
        this.observacionesTemporal = observaciones;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
