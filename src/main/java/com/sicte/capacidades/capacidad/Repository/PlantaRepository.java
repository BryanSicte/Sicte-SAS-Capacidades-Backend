package com.sicte.capacidades.capacidad.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sicte.capacidades.capacidad.Entity.Planta;

@Repository
public interface PlantaRepository extends CrudRepository<Planta, String> {
    public Planta findByNit (String nit);
    public Planta findByNombre (String nombre);
    public Planta findByCiudad (String ciudad);
    public Planta findByCargo (String cargo);
    public Planta findByFechaIngreso (String fechaIngreso);
    public Planta findByCc (String cc);
    public Planta findByScc (String scc);
    public Planta findByFechaRetiro (String fechaRetiro);
    public Planta findByFechaNacimiento (String fechaNacimiento);
    public Planta findByPension (String pension);
    public Planta findBySalud (String salud);
    public Planta findByCesantias (String cesantias);
    public Planta findByCaja (String caja);
    public Planta findByTipoContrato (String tipoContrato);
    public Planta findByPerfil (String perfil);
    public Planta findByAnalista (String analista);
    public Planta findByDirector (String director);
}