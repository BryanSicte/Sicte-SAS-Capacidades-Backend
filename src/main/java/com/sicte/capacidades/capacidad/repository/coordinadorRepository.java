package com.sicte.capacidades.capacidad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.Coordinador;

@Repository
public interface coordinadorRepository extends CrudRepository<Coordinador, String> {
    public Coordinador findByCoordinador (String coordinador);
    public Coordinador findByDirector (String director);
    public Coordinador findByRed (String red);
    public Coordinador findByArea (String area);
    public Coordinador findBySubarea (String subarea);
    public Coordinador findByCliente (String cliente);
}