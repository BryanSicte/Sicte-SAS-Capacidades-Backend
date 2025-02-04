package com.sicte.capacidades.capacidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.capacidadBackup;

@Repository
public interface capacidadBackupRepository extends CrudRepository<capacidadBackup, String> {
    public capacidadBackup findByCedula (String cedula);
    public capacidadBackup findByNombreCompleto (String nombreCompleto);
    public capacidadBackup findByCargo (String cargo);
    public capacidadBackup findByCentroCosto (String centroCosto);
    public capacidadBackup findByNomina (String nomina);
    public capacidadBackup findByRegional (String regional);
    public capacidadBackup findByCiudadTrabajo (String ciudadTrabajo);
    public capacidadBackup findByRed (String red);
    public capacidadBackup findByCliente (String cliente);
    public capacidadBackup findByArea (String area);
    public capacidadBackup findBySubArea (String subArea);
    public capacidadBackup findByCodigoSap (String codigoSap);
    public capacidadBackup findByTipoDeMovil (String tipoDeMovil);
    public capacidadBackup findByTipoFacturacion (String tipoFacturacion);
    public capacidadBackup findByMovil (String movil);
    public capacidadBackup findByCoordinador (String coordinador);
    public capacidadBackup findByDirector (String director);
    public capacidadBackup findByContratista (String contratista);
    public capacidadBackup findByValorEsperado (String valorEsperado);
    public capacidadBackup findByPlaca (String placa);
    public capacidadBackup findByTipoCarro (String tipoCarro);
    public capacidadBackup findByFechaReporte (String fechaReporte);
    public capacidadBackup findByMes (String mes);
    public capacidadBackup findByAño (String año);
    public capacidadBackup findByTurnos (String turnos);
    public capacidadBackup findByPersonas (String personas);
    public capacidadBackup findByCarpeta (String carpeta);

    @Query("SELECT c FROM capacidadBackup c ORDER BY c.fechaReporte DESC")
    List<capacidadBackup> findAllOrderByFechaReporteDesc();

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
