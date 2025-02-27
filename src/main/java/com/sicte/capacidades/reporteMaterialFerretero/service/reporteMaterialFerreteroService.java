package com.sicte.capacidades.reporteMaterialFerretero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.reporteMaterialFerretero.entity.ReporteMaterial;
import com.sicte.capacidades.reporteMaterialFerretero.repository.ReporteMaterialRepository;

@Service
public class ReporteMaterialFerreteroService {
    @Autowired
    ReporteMaterialRepository reporteMaterialFerretero;

    public ReporteMaterial guardarReporteMaterialFerretero(ReporteMaterial registro) {
        return reporteMaterialFerretero.save(registro);
    }

    public List<ReporteMaterial> encontrarTodoReporteMaterialFerretero() {
        return (List<ReporteMaterial>) reporteMaterialFerretero.findAll();
    }
}
