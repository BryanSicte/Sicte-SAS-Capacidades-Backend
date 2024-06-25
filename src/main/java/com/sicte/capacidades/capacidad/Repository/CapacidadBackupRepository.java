package com.sicte.capacidades.capacidad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.Entity.CapacidadBackup;

@Repository
public interface CapacidadBackupRepository extends CrudRepository<CapacidadBackup, String> {
    public CapacidadBackup findByCedula (String cedula);
    public CapacidadBackup findByNombreCompleto (String nombreCompleto);
    public CapacidadBackup findByCargo (String cargo);
    public CapacidadBackup findByCentroCosto (String centroCosto);
    public CapacidadBackup findByNomina (String nomina);
    public CapacidadBackup findByRegional (String regional);
    public CapacidadBackup findByCiudadTrabajo (String ciudadTrabajo);
    public CapacidadBackup findByRed (String red);
    public CapacidadBackup findByCliente (String cliente);
    public CapacidadBackup findByArea (String area);
    public CapacidadBackup findBySubArea (String subArea);
    public CapacidadBackup findByCodigoSap (String codigoSap);
    public CapacidadBackup findByTipoDeMovil (String tipoDeMovil);
    public CapacidadBackup findByTipoFacturacion (String tipoFacturacion);
    public CapacidadBackup findByMovil (String movil);
    public CapacidadBackup findByCoordinador (String coordinador);
    public CapacidadBackup findByDirector (String director);
    public CapacidadBackup findByContratista (String contratista);
    public CapacidadBackup findByValorEsperado (String valorEsperado);
    public CapacidadBackup findByPlaca (String placa);
    public CapacidadBackup findByTipoCarro (String tipoCarro);
    public CapacidadBackup findByFechaReporte (String fechaReporte);
    public CapacidadBackup findByMes (String mes);
    public CapacidadBackup findByAño (String año);
    public CapacidadBackup findByTurnos (String turnos);
    public CapacidadBackup findByPersonas (String personas);

    @Query("SELECT c FROM CapacidadBackup c ORDER BY c.fechaReporte DESC")
    List<CapacidadBackup> findAllOrderByFechaReporteDesc();

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
