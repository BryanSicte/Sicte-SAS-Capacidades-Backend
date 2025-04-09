package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.KdevolHistorico;

@Repository
public interface KdevolHistoricoRepository extends CrudRepository<KdevolHistorico, String> {
    public KdevolHistorico findByLlave(String llave);

    public KdevolHistorico findByFecha(String fecha);

    public KdevolHistorico findByCodConsumidor(String codConsumidor);

    public KdevolHistorico findByNombreConsumidor(String nombreConsumidor);

    public KdevolHistorico findByProducto(String producto);

    public KdevolHistorico findByDescripcion(String descripcion);

    public KdevolHistorico findByUm(String um);

    public KdevolHistorico findByCantidad(String cantidad);

    public KdevolHistorico findByProyecto(String proyecto);

    public KdevolHistorico findByObservacion(String observacion);

    public KdevolHistorico findByFechaDescarga(String fechaDescarga);

    public KdevolHistorico findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
