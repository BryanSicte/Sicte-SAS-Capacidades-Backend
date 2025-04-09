package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.KcnsmuHistorico;

@Repository
public interface KcnsmuHistoricoRepository extends CrudRepository<KcnsmuHistorico, String> {
    public KcnsmuHistorico findByCuenta(String cuenta);

    public KcnsmuHistorico findByOt(String ot);

    public KcnsmuHistorico findByNodo(String nodo);

    public KcnsmuHistorico findByFecha(String fecha);

    public KcnsmuHistorico findByActividad(String actividad);

    public KcnsmuHistorico findByProducto(String producto);

    public KcnsmuHistorico findByDescripcion(String descripcion);

    public KcnsmuHistorico findByCantidad(String cantidad);

    public KcnsmuHistorico findByCeCo(String ceCo);

    public KcnsmuHistorico findByCodSubcon(String codSubcon);

    public KcnsmuHistorico findByMovil(String movil);

    public KcnsmuHistorico findByNroTrabajos(String nroTrabajos);

    public KcnsmuHistorico findByOim(String oim);

    public KcnsmuHistorico findByNroConsumo(String nroConsumo);

    public KcnsmuHistorico findByObservaciones(String observaciones);

    public KcnsmuHistorico findByCodFamilia(String codFamilia);

    public KcnsmuHistorico findByDescripFamilia(String descripFamilia);

    public KcnsmuHistorico findByDescripActividad(String descripActividad);

    public KcnsmuHistorico findByCodTrabajo(String codTrabajo);

    public KcnsmuHistorico findByDescTrabajo(String descTrabajo);

    public KcnsmuHistorico findByAviso(String aviso);

    public KcnsmuHistorico findByFechaReporte(String fechaReporte);

    public KcnsmuHistorico findByUm(String um);

    public KcnsmuHistorico findByTecnico(String tecnico);

    public KcnsmuHistorico findByFechau(String fechau);

    public KcnsmuHistorico findByCodConsum(String codConsum);

    public KcnsmuHistorico findByComplemento(String complemento);

    public KcnsmuHistorico findByFechaDescarga(String fechaDescarga);

    public KcnsmuHistorico findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
