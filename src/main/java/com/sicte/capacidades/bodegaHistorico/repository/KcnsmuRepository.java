package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.Kcnsmu;

@Repository
public interface KcnsmuRepository extends CrudRepository<Kcnsmu, String> {
    public Kcnsmu findByCuenta(String cuenta);

    public Kcnsmu findByOt(String ot);

    public Kcnsmu findByNodo(String nodo);

    public Kcnsmu findByFecha(String fecha);

    public Kcnsmu findByActividad(String actividad);

    public Kcnsmu findByProducto(String producto);

    public Kcnsmu findByDescripcion(String descripcion);

    public Kcnsmu findByCantidad(String cantidad);

    public Kcnsmu findByCeCo(String ceCo);

    public Kcnsmu findByCodSubcon(String codSubcon);

    public Kcnsmu findByMovil(String movil);

    public Kcnsmu findByNroTrabajos(String nroTrabajos);

    public Kcnsmu findByOim(String oim);

    public Kcnsmu findByNroConsumo(String nroConsumo);

    public Kcnsmu findByObservaciones(String observaciones);

    public Kcnsmu findByCodFamilia(String codFamilia);

    public Kcnsmu findByDescripFamilia(String descripFamilia);

    public Kcnsmu findByDescripActividad(String descripActividad);

    public Kcnsmu findByCodTrabajo(String codTrabajo);

    public Kcnsmu findByDescTrabajo(String descTrabajo);

    public Kcnsmu findByAviso(String aviso);

    public Kcnsmu findByFechaReporte(String fechaReporte);

    public Kcnsmu findByUm(String um);

    public Kcnsmu findByTecnico(String tecnico);

    public Kcnsmu findByFechau(String fechau);

    public Kcnsmu findByCodConsum(String codConsum);

    public Kcnsmu findByComplemento(String complemento);

    public Kcnsmu findByFechaDescarga(String fechaDescarga);

    public Kcnsmu findByBodega(String bodega);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery =
    // true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
