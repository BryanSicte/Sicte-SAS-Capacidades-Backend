package com.sicte.capacidades.capacidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.dto.cedulaNombreDto;
import com.sicte.capacidades.capacidad.entity.plantaEnLinea;

@Repository
public interface plantaEnLineaRepository extends CrudRepository<plantaEnLinea, String> {
    public plantaEnLinea findByNit (String nit);
    public plantaEnLinea findByNombre (String nombre);
    public plantaEnLinea findByCiudad (String ciudad);
    public plantaEnLinea findByCargo (String cargo);
    public plantaEnLinea findByFechaIngreso (String fechaIngreso);
    public plantaEnLinea findByCc (String cc);
    public plantaEnLinea findByScc (String scc);
    public plantaEnLinea findByFechaRetiro (String fechaRetiro);
    public plantaEnLinea findByFechaNacimiento (String fechaNacimiento);
    public plantaEnLinea findByTipoContrato (String tipoContrato);
    public plantaEnLinea findByPerfil (String perfil);

    @Query("SELECT new com.sicte.capacidades.capacidad.dto.cedulaNombreDto(p.nit, p.nombre) FROM plantaEnLinea p")
    List<cedulaNombreDto> findCedulaAndNombre();
}