package com.sicte.capacidades.capacidad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.ciudad;

@Repository
public interface ciudadRepository extends CrudRepository<ciudad, String> {
    public ciudad findByCiudad (String ciudad);
    public ciudad findByRegional (String regional);
}