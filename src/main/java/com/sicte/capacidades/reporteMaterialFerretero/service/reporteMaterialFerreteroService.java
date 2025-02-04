package com.sicte.capacidades.reporteMaterialFerretero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.reporteMaterialFerretero.entity.reporteMaterial;
import com.sicte.capacidades.reporteMaterialFerretero.repository.reporteMaterialRepository;

@Service
public class reporteMaterialFerreteroService {
    @Autowired
    reporteMaterialRepository reporteMaterialFerretero;

    public reporteMaterial guardarReporteMaterialFerretero(reporteMaterial registro) {
        return reporteMaterialFerretero.save(registro);
    }

    public List<reporteMaterial> encontrarTodoReporteMaterialFerretero() {
        return (List<reporteMaterial>) reporteMaterialFerretero.findAll();
    }
}
