package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.Ksalcon;

@Repository
public interface KsalconRepository extends CrudRepository<Ksalcon, String> {
    public Ksalcon findByLlave(String llave);

    public Ksalcon findByFecha(String fecha);

    public Ksalcon findByCodconsumidor(String codconsumidor);

    public Ksalcon findByNombre(String nombre);

    public Ksalcon findByProducto(String producto);

    public Ksalcon findByDescrip(String descrip);

    public Ksalcon findByUnimed(String unimed);

    public Ksalcon findByCantidad(String cantidad);

    public Ksalcon findByCodproyecto(String codproyecto);

    public Ksalcon findByNroapoyo(String nroapoyo);

    public Ksalcon findByObserv(String observ);

    public Ksalcon findByIndInstaladores(String indInstaladores);

    public Ksalcon findByNomRecibe(String nomRecibe);

    public Ksalcon findByHoraSal(String horaSal);

    public Ksalcon findByX1(String x1);

    public Ksalcon findByFechaDescarga(String fechaDescarga);

    public Ksalcon findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
