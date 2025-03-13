package com.sicte.capacidades.carnetizacion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.carnetizacion.entity.Carnetizacion;

@Repository
public interface CarnetizacionRepository extends CrudRepository<Carnetizacion, String> {
    public Carnetizacion findByRegistro(String cedulaSupervisor);
    public Carnetizacion findByStage(String nombreSupervisor);
    public Carnetizacion findByAceptoPolitica(String cedulaTecnico);
    public Carnetizacion findBynombreApellido(String nombreTecnico);
    public Carnetizacion findByCelular(String tipoCarnet);
    public Carnetizacion findByCiudad(String solicitud);
    public Carnetizacion findByCargo(String foto);
    public Carnetizacion findByDetalleCargo(String segmento);
    public Carnetizacion findByRespuestaFiltro1(String estado);
}
