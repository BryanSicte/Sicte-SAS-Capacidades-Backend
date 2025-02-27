package com.sicte.capacidades.capacidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.dto.CedulaNombreDto;
import com.sicte.capacidades.capacidad.entity.PlantaEnLinea;

@Repository
public interface PlantaEnLineaRepository extends CrudRepository<PlantaEnLinea, String> {
    public PlantaEnLinea findByNit (String nit);
    public PlantaEnLinea findByNombre (String nombre);
    public PlantaEnLinea findByCiudad (String ciudad);
    public PlantaEnLinea findByCargo (String cargo);
    public PlantaEnLinea findByFechaIngreso (String fechaIngreso);
    public PlantaEnLinea findByCc (String cc);
    public PlantaEnLinea findByScc (String scc);
    public PlantaEnLinea findByFechaRetiro (String fechaRetiro);
    public PlantaEnLinea findByFechaNacimiento (String fechaNacimiento);
    public PlantaEnLinea findByTipoContrato (String tipoContrato);
    public PlantaEnLinea findByPerfil (String perfil);

    @Query("SELECT new com.sicte.capacidades.capacidad.dto.CedulaNombreDto(p.nit, p.nombre) FROM PlantaEnLinea p")
    List<CedulaNombreDto> findCedulaAndNombre();
}