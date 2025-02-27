package com.sicte.capacidades.solicitudMaterial.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NamePDFSave {
    private List<Long> ids;
    private String pdfNombre;

    // Getters y setters
    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getPdfNombre() {
        return pdfNombre;
    }

    public void setPdfNombre(String pdfNombre) {
        this.pdfNombre = pdfNombre;
    }
}
