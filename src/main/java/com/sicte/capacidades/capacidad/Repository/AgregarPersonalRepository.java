package com.sicte.capacidades.capacidad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.agregarPersonal;

@Repository
public interface agregarPersonalRepository extends CrudRepository<agregarPersonal, String> {
    public agregarPersonal findByCedula (String cedula);
    public agregarPersonal findByCarpeta (String carpeta);
    public agregarPersonal findByPlaca (String placa);
    public agregarPersonal findByTipoFacturacion (String tipoFacturacion);
    public agregarPersonal findByTipoMovil (String tipoMovil);
    public agregarPersonal findByCoordinador (String coordinador);
}