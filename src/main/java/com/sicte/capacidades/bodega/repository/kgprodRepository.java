package com.sicte.capacidades.bodega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodega.entity.Kgprod;

@Repository
public interface KgprodRepository extends CrudRepository<Kgprod, String> {
    public Kgprod findByCodigo(String codigo);
    public Kgprod findByDescrip(String descrip);
    public Kgprod findByUnimed(String unimed);
    public Kgprod findBySerial(String serial);
    public Kgprod findByNvmin(String nvmin);
    public Kgprod findByCandisp(String candisp);
    public Kgprod findByCantent(String cantent);
    public Kgprod findByCantres(String cantres);
    public Kgprod findByCantove(String cantove);
    public Kgprod findByMovilres(String movilres);
    public Kgprod findByMovilove(String movilove);
    public Kgprod findByMovilman(String movilman);
    public Kgprod findByFchinvfis(String fchinvfis);
    public Kgprod findByBodres(String bodres);
    public Kgprod findByBodove(String bodove);
    public Kgprod findByCantaco(String cantaco);
    public Kgprod findByMovilaco(String movilaco);
    public Kgprod findByBodaco(String bodaco);
    public Kgprod findByDeltaifbo(String deltaifbo);
    public Kgprod findByDeltaifmv(String deltaifmv);
    public Kgprod findByPepsDeBod(String pepsDeBod);
    public Kgprod findByUbicacion(String ubicacion);
    public Kgprod findByIndInstaladores(String indInstaladores);
    public Kgprod findByInvfis(String invfis);
    public Kgprod findByLoteRolloNada(String loteRolloNada);
    public Kgprod findByIndComprado(String indComprado);
    public Kgprod findByFechaDescarga(String fechaDescarga);
    public Kgprod findByBodega(String bodega);
    public Kgprod findByIndComprado2(String indComprado2);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
