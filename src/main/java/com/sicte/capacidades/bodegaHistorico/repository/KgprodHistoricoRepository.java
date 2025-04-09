package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.KgprodHistorico;

@Repository
public interface KgprodHistoricoRepository extends CrudRepository<KgprodHistorico, String> {
    public KgprodHistorico findByCodigo(String codigo);

    public KgprodHistorico findByDescrip(String descrip);

    public KgprodHistorico findByUnimed(String unimed);

    public KgprodHistorico findBySerial(String serial);

    public KgprodHistorico findByNvmin(String nvmin);

    public KgprodHistorico findByCandisp(String candisp);

    public KgprodHistorico findByCantent(String cantent);

    public KgprodHistorico findByCantres(String cantres);

    public KgprodHistorico findByCantove(String cantove);

    public KgprodHistorico findByMovilres(String movilres);

    public KgprodHistorico findByMovilove(String movilove);

    public KgprodHistorico findByMovilman(String movilman);

    public KgprodHistorico findByFchinvfis(String fchinvfis);

    public KgprodHistorico findByBodres(String bodres);

    public KgprodHistorico findByBodove(String bodove);

    public KgprodHistorico findByCantaco(String cantaco);

    public KgprodHistorico findByMovilaco(String movilaco);

    public KgprodHistorico findByBodaco(String bodaco);

    public KgprodHistorico findByDeltaifbo(String deltaifbo);

    public KgprodHistorico findByDeltaifmv(String deltaifmv);

    public KgprodHistorico findByPepsDeBod(String pepsDeBod);

    public KgprodHistorico findByUbicacion(String ubicacion);

    public KgprodHistorico findByIndInstaladores(String indInstaladores);

    public KgprodHistorico findByInvfis(String invfis);

    public KgprodHistorico findByLoteRolloNada(String loteRolloNada);

    public KgprodHistorico findByIndComprado(String indComprado);

    public KgprodHistorico findByFechaDescarga(String fechaDescarga);

    public KgprodHistorico findByBodega(String bodega);

    public KgprodHistorico findByIndComprado2(String indComprado2);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
