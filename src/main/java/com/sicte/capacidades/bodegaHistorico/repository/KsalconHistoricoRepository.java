package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.KsalconHistorico;

@Repository
public interface KsalconHistoricoRepository extends CrudRepository<KsalconHistorico, String> {
    public KsalconHistorico findByLlave(String llave);

    public KsalconHistorico findByFecha(String fecha);

    public KsalconHistorico findByCodconsumidor(String codconsumidor);

    public KsalconHistorico findByNombre(String nombre);

    public KsalconHistorico findByProducto(String producto);

    public KsalconHistorico findByDescrip(String descrip);

    public KsalconHistorico findByUnimed(String unimed);

    public KsalconHistorico findByCantidad(String cantidad);

    public KsalconHistorico findByCodproyecto(String codproyecto);

    public KsalconHistorico findByNroapoyo(String nroapoyo);

    public KsalconHistorico findByObserv(String observ);

    public KsalconHistorico findByIndInstaladores(String indInstaladores);

    public KsalconHistorico findByNomRecibe(String nomRecibe);

    public KsalconHistorico findByHoraSal(String horaSal);

    public KsalconHistorico findByX1(String x1);

    public KsalconHistorico findByFechaDescarga(String fechaDescarga);

    public KsalconHistorico findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
