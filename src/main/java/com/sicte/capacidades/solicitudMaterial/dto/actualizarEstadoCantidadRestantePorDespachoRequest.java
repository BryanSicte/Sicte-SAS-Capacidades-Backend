package com.sicte.capacidades.solicitudMaterial.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ActualizarEstadoCantidadRestantePorDespachoRequest {
    private List<Long> ids;
    private List<String> cantidades;

    // Getters y setters
    public List<Long> getIds() {
        return ids;
    }
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<String> getCantidades() {
        return cantidades;
    }
    public void setCantidades(List<String> cantidades) {
        this.cantidades = cantidades;
    }
}
