package com.sicte.capacidades.capacidad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.AgregarPersonal;

@Repository
public interface AgregarPersonalRepository extends CrudRepository<AgregarPersonal, String> {
    public AgregarPersonal findByCedula (String cedula);
    public AgregarPersonal findByCarpeta (String carpeta);
    public AgregarPersonal findByPlaca (String placa);
    public AgregarPersonal findByTipoFacturacion (String tipoFacturacion);
    public AgregarPersonal findByTipoMovil (String tipoMovil);
    public AgregarPersonal findByCoordinador (String coordinador);
}