package com.sicte.capacidades.capacidad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sicte.capacidades.capacidad.entity.planta;

@Repository
public interface plantaRepository extends CrudRepository<planta, String> {
    public planta findByNit (String nit);
    public planta findByNombre (String nombre);
    public planta findByCiudad (String ciudad);
    public planta findByCargo (String cargo);
    public planta findByFechaIngreso (String fechaIngreso);
    public planta findByCc (String cc);
    public planta findByScc (String scc);
    public planta findByFechaRetiro (String fechaRetiro);
    public planta findByFechaNacimiento (String fechaNacimiento);
    public planta findByPension (String pension);
    public planta findBySalud (String salud);
    public planta findByCesantias (String cesantias);
    public planta findByCaja (String caja);
    public planta findByTipoContrato (String tipoContrato);
    public planta findByPerfil (String perfil);
    public planta findByAnalista (String analista);
    public planta findByDirector (String director);
}