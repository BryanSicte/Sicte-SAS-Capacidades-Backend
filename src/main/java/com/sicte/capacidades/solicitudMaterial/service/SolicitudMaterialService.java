package com.sicte.capacidades.solicitudMaterial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.solicitudMaterial.entity.RegistrosSolicitudMaterial;
import com.sicte.capacidades.solicitudMaterial.entity.RegistrosSolicitudMaterialEntregado;
import com.sicte.capacidades.solicitudMaterial.entity.RelacionPersonal;
import com.sicte.capacidades.solicitudMaterial.repository.RegistrosSolicitudMaterialEntregadoRepository;
import com.sicte.capacidades.solicitudMaterial.repository.RegistrosSolicitudMaterialRepository;
import com.sicte.capacidades.solicitudMaterial.repository.RelacionPersonalRepository;

@Service
public class SolicitudMaterialService{
    @Autowired
    RegistrosSolicitudMaterialRepository registrosRepository;
    @Autowired
    RegistrosSolicitudMaterialEntregadoRepository registrosEntregaRepository;
    @Autowired
    RelacionPersonalRepository relacionPersonalRepository;

    public RegistrosSolicitudMaterialEntregado guardarRegistroEntregado(RegistrosSolicitudMaterialEntregado registro) {
        return registrosEntregaRepository.save(registro);
    }

    public List<RegistrosSolicitudMaterialEntregado> encontrarTodoRegistrosEntregado() {
        return (List<RegistrosSolicitudMaterialEntregado>) registrosEntregaRepository.findAll();
    }

    public RegistrosSolicitudMaterial guardarRegistro(RegistrosSolicitudMaterial registro) {
        return registrosRepository.save(registro);
    }

    public List<RegistrosSolicitudMaterial> encontrarTodoRegistros() {
        return (List<RegistrosSolicitudMaterial>) registrosRepository.findAll();
    }

    public void actualizarEstadoAnalista(Long id, String estado, String observaciones, String fecha) {
        registrosRepository.actualizarEstadoAnalista(id, estado, observaciones, fecha);
    }

    public void actualizarEstadoDirector(Long id, String estado, String observaciones, String fecha) {
        registrosRepository.actualizarEstadoDirector(id, estado, observaciones, fecha);
    }

    public void actualizarEstadoDireccionOperacion(Long id, String estado, String observaciones, String fecha) {
        registrosRepository.actualizarEstadoDireccionOperacion(id, estado, observaciones, fecha);
    }

    public void actualizarEstadoEntregaBodega(Long id, String estado, String observaciones) {
        registrosRepository.actualizarEstadoEntregaBodega(id, estado, observaciones);
    }

    public void actualizarEstadoCantidadRestantePorDespacho(Long id, String cantidad) {
        registrosRepository.actualizarEstadoCantidadRestantePorDespacho(id, cantidad);
    }

    public void actualizarEstadoEntregaBodegaPDFs(Long id, String namePdfs) {
        registrosRepository.actualizarEstadoEntregaBodegaPDFs(id, namePdfs);
    }

    public List<RelacionPersonal> encontrarTodoRelacionPersonal() {
        return (List<RelacionPersonal>) relacionPersonalRepository.findAll();
    }

    public void actualizarEstadoCantidaDisponibleMaterial(Long id, String cantidad) {
        registrosRepository.actualizarEstadoCantidadDisponibleMaterial(id, cantidad);
    }

    public void actualizarEstadoCierreProyecto(Long id, String estadoProyecto) {
        registrosRepository.actualizarEstadoCierreProyecto(id, estadoProyecto);
    }
}
