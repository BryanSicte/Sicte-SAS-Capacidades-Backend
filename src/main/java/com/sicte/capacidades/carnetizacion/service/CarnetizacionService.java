package com.sicte.capacidades.carnetizacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.carnetizacion.entity.Carnetizacion;
import com.sicte.capacidades.carnetizacion.repository.CarnetizacionRepository;

@Service
public class CarnetizacionService{

    @Autowired
    CarnetizacionRepository carnetizacionRepository;

    public List<Carnetizacion> encontrarTodoRegistros() {
        return (List<Carnetizacion>) carnetizacionRepository.findAll();
    }
}
