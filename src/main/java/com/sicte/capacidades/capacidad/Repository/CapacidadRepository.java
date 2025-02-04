package com.sicte.capacidades.capacidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.capacidad;

import jakarta.transaction.Transactional;

@Repository
public interface capacidadRepository extends CrudRepository<capacidad, String> {
    public capacidad findByCedula (String cedula);
    public capacidad findByNombreCompleto (String nombreCompleto);
    public capacidad findByCargo (String cargo);
    public capacidad findByCentroCosto (String centroCosto);
    public capacidad findByNomina (String nomina);
    public capacidad findByRegional (String regional);
    public capacidad findByCiudadTrabajo (String ciudadTrabajo);
    public capacidad findByRed (String red);
    public capacidad findByCliente (String cliente);
    public capacidad findByArea (String area);
    public capacidad findBySubArea (String subArea);
    public capacidad findByCodigoSap (String codigoSap);
    public capacidad findByTipoDeMovil (String tipoDeMovil);
    public capacidad findByTipoFacturacion (String tipoFacturacion);
    public capacidad findByMovil (String movil);
    public capacidad findByCoordinador (String coordinador);
    public capacidad findByDirector (String director);
    public capacidad findByContratista (String contratista);
    public capacidad findByValorEsperado (String valorEsperado);
    public capacidad findByPlaca (String placa);
    public capacidad findByTipoCarro (String tipoCarro);
    public capacidad findByFechaReporte (String fechaReporte);
    public capacidad findByMes (String mes);
    public capacidad findByAño (String año);
    public capacidad findByTurnos (String turnos);
    public capacidad findByPersonas (String personas);
    public capacidad findByCarpeta (String carpeta);

    @Query("SELECT c FROM capacidad c ORDER BY c.fechaReporte DESC")
    List<capacidad> findAllOrderByFechaReporteDesc();

    public static class RoleRequest {
        private String role;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    @Modifying
    @Transactional
    @Query("DELETE FROM capacidad c WHERE c.cedula = :cedula")
    void deleteByCedula(String cedula);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
