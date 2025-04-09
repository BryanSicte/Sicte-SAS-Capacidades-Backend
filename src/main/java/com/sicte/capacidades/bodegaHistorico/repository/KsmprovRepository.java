package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.Ksmprov;

@Repository
public interface KsmprovRepository extends CrudRepository<Ksmprov, String> {
    public Ksmprov findByLlave(String llave);

    public Ksmprov findByFecha(String fecha);

    public Ksmprov findByCodproveedor(String codproveedor);

    public Ksmprov findByNombre(String nombre);

    public Ksmprov findByProducto(String producto);

    public Ksmprov findByDescrip(String descrip);

    public Ksmprov findByUnimed(String unimed);

    public Ksmprov findByCantidad(String cantidad);

    public Ksmprov findByObservacion(String observacion);

    public Ksmprov findByUsuario(String usuario);

    public Ksmprov findByFechau(String fechau);

    public Ksmprov findByFechaDescarga(String fechaDescarga);

    public Ksmprov findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
