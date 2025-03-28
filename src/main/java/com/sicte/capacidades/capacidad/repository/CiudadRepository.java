package com.sicte.capacidades.capacidad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, String> {
    public Ciudad findByCiudad (String ciudad);
    public Ciudad findByRegional (String regional);
}