package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.Kentinv;

@Repository
public interface KentinvRepository extends CrudRepository<Kentinv, String> {
    public Kentinv findByLlave(String llave);

    public Kentinv findByFecha(String fecha);

    public Kentinv findByNrocomproC(String nrocomproC);

    public Kentinv findByNrosolmat(String nrosolmat);

    public Kentinv findByProducto(String producto);

    public Kentinv findByDescrip(String descrip);

    public Kentinv findByUnimed(String unimed);

    public Kentinv findByCanrecib(String canrecib);

    public Kentinv findByConciliacion(String conciliacion);

    public Kentinv findByFacturacion(String facturacion);

    public Kentinv findByBodres(String bodres);

    public Kentinv findByBodove(String bodove);

    public Kentinv findByBodaco(String bodaco);

    public Kentinv findByNombre(String nombre);

    public Kentinv findByFechaDescarga(String fechaDescarga);

    public Kentinv findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
