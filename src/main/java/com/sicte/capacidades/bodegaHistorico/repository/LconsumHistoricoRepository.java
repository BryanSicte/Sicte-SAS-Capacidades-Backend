package com.sicte.capacidades.bodegaHistorico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodegaHistorico.entity.LconsumHistorico;

@Repository
public interface LconsumHistoricoRepository extends CrudRepository<LconsumHistorico, String> {
    public LconsumHistorico findByLlave(String llave);

    public LconsumHistorico findByNombre(String nombre);

    public LconsumHistorico findByTipoConsumidor(String tipoConsumidor);

    public LconsumHistorico findByFechasal(String fechasal);

    public LconsumHistorico findByEstadosal(String estadosal);

    public LconsumHistorico findByEncursosal(String encursosal);

    public LconsumHistorico findByResponsable(String responsable);

    public LconsumHistorico findByIndBorrado(String indBorrado);

    public LconsumHistorico findByDescripcion(String descripcion);

    public LconsumHistorico findByLlave1(String llave1);

    public LconsumHistorico findBySupervisor(String supervisor);

    public LconsumHistorico findByFchControl(String fchControl);

    public LconsumHistorico findByNombreC(String nombreC);

    public LconsumHistorico findByDocIdent(String docIdent);

    public LconsumHistorico findByCodCuadrxdef(String codCuadrxdef);

    public LconsumHistorico findByUsuario(String usuario);

    public LconsumHistorico findByFechau(String fechau);

    public LconsumHistorico findByUsuariom(String usuariom);

    public LconsumHistorico findByFechaum(String fechaum);

    public LconsumHistorico findByTipoMovil(String tipoMovil);

    public LconsumHistorico findByControladoNomina(String controladoNomina);

    public LconsumHistorico findByFechaDescarga(String fechaDescarga);

    public LconsumHistorico findByBodega(String bodega);
}
