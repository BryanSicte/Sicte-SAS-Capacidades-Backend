package com.sicte.capacidades.supervision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.supervision.dto.placaFechaDto;
import com.sicte.capacidades.supervision.entity.registros;
import com.sicte.capacidades.supervision.repository.registrosRepository;

@Service
public class supervisionService{
    @Autowired
    registrosRepository registrosRepository;

    public registros guardarRegistro(registros registro) {
        return registrosRepository.save(registro);
    }

    public List<registros> encontrarTodoRegistros() {
        return (List<registros>) registrosRepository.findAll();
    }

    public List<placaFechaDto> encontrarFechaYPlacaRegistros() {
        return registrosRepository.findFechaAndPlaca();
    }

}
