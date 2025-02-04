package com.sicte.capacidades.bodega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodega.entity.kgprod;

@Repository
public interface kgprodRepository extends CrudRepository<kgprod, String> {
    public kgprod findByCodigo(String codigo);
    public kgprod findByDescrip(String descrip);
    public kgprod findByUnimed(String unimed);
    public kgprod findBySerial(String serial);
    public kgprod findByNvmin(String nvmin);
    public kgprod findByCandisp(String candisp);
    public kgprod findByCantent(String cantent);
    public kgprod findByCantres(String cantres);
    public kgprod findByCantove(String cantove);
    public kgprod findByMovilres(String movilres);
    public kgprod findByMovilove(String movilove);
    public kgprod findByMovilman(String movilman);
    public kgprod findByFchinvfis(String fchinvfis);
    public kgprod findByBodres(String bodres);
    public kgprod findByBodove(String bodove);
    public kgprod findByCantaco(String cantaco);
    public kgprod findByMovilaco(String movilaco);
    public kgprod findByBodaco(String bodaco);
    public kgprod findByDeltaifbo(String deltaifbo);
    public kgprod findByDeltaifmv(String deltaifmv);
    public kgprod findByPepsDeBod(String pepsDeBod);
    public kgprod findByUbicacion(String ubicacion);
    public kgprod findByIndInstaladores(String indInstaladores);
    public kgprod findByInvfis(String invfis);
    public kgprod findByLoteRolloNada(String loteRolloNada);
    public kgprod findByIndComprado(String indComprado);
    public kgprod findByFechaDescarga(String fechaDescarga);
    public kgprod findByBodega(String bodega);
    public kgprod findByIndComprado2(String indComprado2);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
