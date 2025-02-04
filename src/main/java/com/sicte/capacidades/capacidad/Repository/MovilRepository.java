package com.sicte.capacidades.capacidad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.movil;

@Repository
public interface movilRepository extends CrudRepository<movil, String> {
    public movil findByTipoMovil (String tipoMovil);
    public movil findByTipoFacturacion (String tipoFacturacion);
    public movil findByTurnos (String turnos);
    public movil findByPersonas (String personas);
    public movil findByMovil (String movil);
    public movil findByValorEsperado (String valorEsperado);
}