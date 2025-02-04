package com.sicte.capacidades.bodega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodega.entity.lconsum;

@Repository
public interface lconsumRepository extends CrudRepository<lconsum, String> {
    public lconsum findByLlave(String llave);
    public lconsum findByNombre(String nombre);
    public lconsum findByTipoConsumidor(String tipoConsumidor);
    public lconsum findByFechasal(String fechasal);
    public lconsum findByEstadosal(String estadosal);
    public lconsum findByEncursosal(String encursosal);
    public lconsum findByResponsable(String responsable);
    public lconsum findByIndBorrado(String indBorrado);
    public lconsum findByDescripcion(String descripcion);
    public lconsum findByLlave1(String llave1);
    public lconsum findBySupervisor(String supervisor);
    public lconsum findByFchControl(String fchControl);
    public lconsum findByNombreC(String nombreC);
    public lconsum findByDocIdent(String docIdent);
    public lconsum findByCodCuadrxdef(String codCuadrxdef);
    public lconsum findByUsuario(String usuario);
    public lconsum findByFechau(String fechau);
    public lconsum findByUsuariom(String usuariom);
    public lconsum findByFechaum(String fechaum);
    public lconsum findByTipoMovil(String tipoMovil);
    public lconsum findByControladoNomina(String controladoNomina);
    public lconsum findByFechaDescarga(String fechaDescarga);
    public lconsum findByBodega(String bodega);
}
