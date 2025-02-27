package com.sicte.capacidades.supervision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.supervision.dto.PlacaFechaDto;
import com.sicte.capacidades.supervision.entity.Registros;
import com.sicte.capacidades.supervision.repository.RegistrosRepository;

@Service
public class SupervisionService{
    @Autowired
    RegistrosRepository registrosRepository;

    public Registros guardarRegistro(Registros registro) {
        return registrosRepository.save(registro);
    }

    public List<Registros> encontrarTodoRegistros() {
        return (List<Registros>) registrosRepository.findAll();
    }

    public List<PlacaFechaDto> encontrarFechaYPlacaRegistros() {
        return registrosRepository.findFechaAndPlaca();
    }

}
