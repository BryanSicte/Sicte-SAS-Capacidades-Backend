package com.sicte.capacidades.solicitudMaterial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.solicitudMaterial.entity.registrosSolicitudMaterial;
import com.sicte.capacidades.solicitudMaterial.entity.registrosSolicitudMaterialEntregado;
import com.sicte.capacidades.solicitudMaterial.entity.relacionPersonal;
import com.sicte.capacidades.solicitudMaterial.repository.registrosSolicitudMaterialEntregadoRepository;
import com.sicte.capacidades.solicitudMaterial.repository.registrosSolicitudMaterialRepository;
import com.sicte.capacidades.solicitudMaterial.repository.relacionPersonalRepository;

@Service
public class solicitudMaterialService{
    @Autowired
    registrosSolicitudMaterialRepository registrosRepository;
    @Autowired
    registrosSolicitudMaterialEntregadoRepository registrosEntregaRepository;
    @Autowired
    relacionPersonalRepository relacionPersonalRepository;

    public registrosSolicitudMaterialEntregado guardarRegistroEntregado(registrosSolicitudMaterialEntregado registro) {
        return registrosEntregaRepository.save(registro);
    }

    public List<registrosSolicitudMaterialEntregado> encontrarTodoRegistrosEntregado() {
        return (List<registrosSolicitudMaterialEntregado>) registrosEntregaRepository.findAll();
    }

    public registrosSolicitudMaterial guardarRegistro(registrosSolicitudMaterial registro) {
        return registrosRepository.save(registro);
    }

    public List<registrosSolicitudMaterial> encontrarTodoRegistros() {
        return (List<registrosSolicitudMaterial>) registrosRepository.findAll();
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

    public List<relacionPersonal> encontrarTodoRelacionPersonal() {
        return (List<relacionPersonal>) relacionPersonalRepository.findAll();
    }

    public void actualizarEstadoCantidaDisponibleMaterial(Long id, String cantidad) {
        registrosRepository.actualizarEstadoCantidadDisponibleMaterial(id, cantidad);
    }

    public void actualizarEstadoCierreProyecto(Long id, String estadoProyecto) {
        registrosRepository.actualizarEstadoCierreProyecto(id, estadoProyecto);
    }
}
