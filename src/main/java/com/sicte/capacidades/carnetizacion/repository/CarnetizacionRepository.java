package com.sicte.capacidades.carnetizacion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.carnetizacion.entity.Carnetizacion;

@Repository
public interface CarnetizacionRepository extends CrudRepository<Carnetizacion, String> {
    public Carnetizacion findByRegistro(String registro);

    public Carnetizacion findByCedulaSupervisor(String cedulaSupervisor);

    public Carnetizacion findByNombreSupervisor(String nombreSupervisor);

    public Carnetizacion findByCedulaTecnico(String cedulaTecnico);

    public Carnetizacion findByNombreTecnico(String nombreTecnico);

    public Carnetizacion findByTipoCarnet(String tipoCarnet);

    public Carnetizacion findBySolicitud(String solicitud);

    public Carnetizacion findByFoto(String foto);

    public Carnetizacion findBySegmento(String segmento);

    public Carnetizacion findByEstado(String estado);
}
