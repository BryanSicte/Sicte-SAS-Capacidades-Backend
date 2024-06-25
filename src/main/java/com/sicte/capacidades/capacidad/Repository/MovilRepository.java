package com.sicte.capacidades.capacidad.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.Entity.Movil;

@Repository
public interface MovilRepository extends CrudRepository<Movil, String> {
    public Movil findByTipoMovil (String tipoMovil);
    public Movil findByTipoFacturacion (String tipoFacturacion);
    public Movil findByTurnos (String turnos);
    public Movil findByPersonas (String personas);
    public Movil findByMovil (String movil);
    public Movil findByValorEsperado (String valorEsperado);
}