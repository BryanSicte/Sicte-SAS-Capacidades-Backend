package com.sicte.capacidades.capacidad.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.Entity.Coordinador;

@Repository
public interface CoordinadorRepository extends CrudRepository<Coordinador, String> {
    public Coordinador findByCoordinador (String coordinador);
    public Coordinador findByDirector (String director);
    public Coordinador findByRed (String red);
    public Coordinador findByArea (String area);
    public Coordinador findBySubarea (String subarea);
    public Coordinador findByCliente (String cliente);
}