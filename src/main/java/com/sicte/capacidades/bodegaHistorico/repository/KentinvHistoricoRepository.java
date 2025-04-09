package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.KentinvHistorico;

@Repository
public interface KentinvHistoricoRepository extends CrudRepository<KentinvHistorico, String> {
    public KentinvHistorico findByLlave(String llave);

    public KentinvHistorico findByFecha(String fecha);

    public KentinvHistorico findByNrocomproC(String nrocomproC);

    public KentinvHistorico findByNrosolmat(String nrosolmat);

    public KentinvHistorico findByProducto(String producto);

    public KentinvHistorico findByDescrip(String descrip);

    public KentinvHistorico findByUnimed(String unimed);

    public KentinvHistorico findByCanrecib(String canrecib);

    public KentinvHistorico findByConciliacion(String conciliacion);

    public KentinvHistorico findByFacturacion(String facturacion);

    public KentinvHistorico findByBodres(String bodres);

    public KentinvHistorico findByBodove(String bodove);

    public KentinvHistorico findByBodaco(String bodaco);

    public KentinvHistorico findByNombre(String nombre);

    public KentinvHistorico findByFechaDescarga(String fechaDescarga);

    public KentinvHistorico findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
