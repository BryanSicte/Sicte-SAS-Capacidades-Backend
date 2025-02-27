package com.sicte.capacidades.bodega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.bodega.entity.Lconsum;

@Repository
public interface LconsumRepository extends CrudRepository<Lconsum, String> {
    public Lconsum findByLlave(String llave);
    public Lconsum findByNombre(String nombre);
    public Lconsum findByTipoConsumidor(String tipoConsumidor);
    public Lconsum findByFechasal(String fechasal);
    public Lconsum findByEstadosal(String estadosal);
    public Lconsum findByEncursosal(String encursosal);
    public Lconsum findByResponsable(String responsable);
    public Lconsum findByIndBorrado(String indBorrado);
    public Lconsum findByDescripcion(String descripcion);
    public Lconsum findByLlave1(String llave1);
    public Lconsum findBySupervisor(String supervisor);
    public Lconsum findByFchControl(String fchControl);
    public Lconsum findByNombreC(String nombreC);
    public Lconsum findByDocIdent(String docIdent);
    public Lconsum findByCodCuadrxdef(String codCuadrxdef);
    public Lconsum findByUsuario(String usuario);
    public Lconsum findByFechau(String fechau);
    public Lconsum findByUsuariom(String usuariom);
    public Lconsum findByFechaum(String fechaum);
    public Lconsum findByTipoMovil(String tipoMovil);
    public Lconsum findByControladoNomina(String controladoNomina);
    public Lconsum findByFechaDescarga(String fechaDescarga);
    public Lconsum findByBodega(String bodega);
}
