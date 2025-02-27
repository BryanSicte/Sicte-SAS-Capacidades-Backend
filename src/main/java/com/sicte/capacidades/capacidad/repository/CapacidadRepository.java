package com.sicte.capacidades.capacidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.capacidad.entity.Capacidad;

import jakarta.transaction.Transactional;

@Repository
public interface CapacidadRepository extends CrudRepository<Capacidad, String> {
    public Capacidad findByCedula (String cedula);
    public Capacidad findByNombreCompleto (String nombreCompleto);
    public Capacidad findByCargo (String cargo);
    public Capacidad findByCentroCosto (String centroCosto);
    public Capacidad findByNomina (String nomina);
    public Capacidad findByRegional (String regional);
    public Capacidad findByCiudadTrabajo (String ciudadTrabajo);
    public Capacidad findByRed (String red);
    public Capacidad findByCliente (String cliente);
    public Capacidad findByArea (String area);
    public Capacidad findBySubArea (String subArea);
    public Capacidad findByCodigoSap (String codigoSap);
    public Capacidad findByTipoDeMovil (String tipoDeMovil);
    public Capacidad findByTipoFacturacion (String tipoFacturacion);
    public Capacidad findByMovil (String movil);
    public Capacidad findByCoordinador (String coordinador);
    public Capacidad findByDirector (String director);
    public Capacidad findByContratista (String contratista);
    public Capacidad findByValorEsperado (String valorEsperado);
    public Capacidad findByPlaca (String placa);
    public Capacidad findByTipoCarro (String tipoCarro);
    public Capacidad findByFechaReporte (String fechaReporte);
    public Capacidad findByMes (String mes);
    public Capacidad findByAño (String año);
    public Capacidad findByTurnos (String turnos);
    public Capacidad findByPersonas (String personas);
    public Capacidad findByCarpeta (String carpeta);

    @Query("SELECT c FROM Capacidad c ORDER BY c.fechaReporte DESC")
    List<Capacidad> findAllOrderByFechaReporteDesc();

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
    @Query("DELETE FROM Capacidad c WHERE c.cedula = :cedula")
    void deleteByCedula(String cedula);

    // @Transactional(readOnly = true)
    // @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    // public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);
}
