package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.Kdevol;

@Repository
public interface KdevolRepository extends CrudRepository<Kdevol, String> {
    public Kdevol findByLlave(String llave);

    public Kdevol findByFecha(String fecha);

    public Kdevol findByCodConsumidor(String codConsumidor);

    public Kdevol findByNombreConsumidor(String nombreConsumidor);

    public Kdevol findByProducto(String producto);

    public Kdevol findByDescripcion(String descripcion);

    public Kdevol findByUm(String um);

    public Kdevol findByCantidad(String cantidad);

    public Kdevol findByProyecto(String proyecto);

    public Kdevol findByObservacion(String observacion);

    public Kdevol findByFechaDescarga(String fechaDescarga);

    public Kdevol findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
