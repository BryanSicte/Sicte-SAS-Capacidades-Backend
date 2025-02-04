package com.sicte.capacidades.capacidad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.coordinador;

@Repository
public interface coordinadorRepository extends CrudRepository<coordinador, String> {
    public coordinador findByCoordinador (String coordinador);
    public coordinador findByDirector (String director);
    public coordinador findByRed (String red);
    public coordinador findByArea (String area);
    public coordinador findBySubarea (String subarea);
    public coordinador findByCliente (String cliente);
}