package com.sicte.capacidades.solicitudMaterial.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sicte.capacidades.solicitudMaterial.entity.RegistrosSolicitudMaterial;

@Repository
public interface RegistrosSolicitudMaterialRepository extends CrudRepository<RegistrosSolicitudMaterial, String> {
        public RegistrosSolicitudMaterial findByFecha(String fecha);

        public RegistrosSolicitudMaterial findByCedula(String cedula);

        public RegistrosSolicitudMaterial findByNombre(String nombre);

        public RegistrosSolicitudMaterial findByCiudad(String ciudad);

        public RegistrosSolicitudMaterial findByDiseño(String diseño);

        public RegistrosSolicitudMaterial findByKmz(String kmz);

        public RegistrosSolicitudMaterial findByUuid(String uuid);

        public RegistrosSolicitudMaterial findByNombreProyecto(String nombreProyecto);

        public RegistrosSolicitudMaterial findByEntregaProyecto(String entregaProyecto);

        public RegistrosSolicitudMaterial findByPropiedadMaterial(String propiedadMaterial);

        public RegistrosSolicitudMaterial findByCodigoSapMaterial(String codigoSapMaterial);

        public RegistrosSolicitudMaterial findByDescripcionMaterial(String descripcionMaterial);

        public RegistrosSolicitudMaterial findByUnidadMedidaMaterial(String unidadMedidaMaterial);

        public RegistrosSolicitudMaterial findByCantidadDisponibleMaterial(String cantidadDisponibleMaterial);

        public RegistrosSolicitudMaterial findByCantidadSolicitadaMaterial(String cantidadSolicitadaMaterial);
        
        public RegistrosSolicitudMaterial findByCantidadRestantePorDespacho(String cantidadRestantePorDespacho);

        public RegistrosSolicitudMaterial findByAprobacionAnalista(String aprobacionAnalista);

        public RegistrosSolicitudMaterial findByFechaAnalista(String fechaAnalista);

        public RegistrosSolicitudMaterial findByObservacionesAnalista(String observacionesAnalista);

        public RegistrosSolicitudMaterial findByAprobacionDirector(String aprobacionDirector);

        public RegistrosSolicitudMaterial findByFechaDirector(String fechaDirector);

        public RegistrosSolicitudMaterial findByObservacionesDirector(String observacionesDirector);

        public RegistrosSolicitudMaterial findByAprobacionDireccionOperacion(String aprobacionDireccionOperacion);

        public RegistrosSolicitudMaterial findByFechaDireccionOperacion(String fechaDireccionOperacion);

        public RegistrosSolicitudMaterial findByObservacionesDireccionOperacion(String observacionesDireccionOperacion);

        public RegistrosSolicitudMaterial findByEntregaBodega(String entregaBodega);

        public RegistrosSolicitudMaterial findByObservacionesEntregaBodega(String observacionesEntregaBodega);

        public RegistrosSolicitudMaterial findByPdfs(String pdfs);

        public RegistrosSolicitudMaterial findByEstadoProyecto(String estadoProyecto);

        @Modifying
        @Transactional
        @Query("UPDATE RegistrosSolicitudMaterial s SET s.aprobacionAnalista = :estado, s.observacionesAnalista = :observaciones, s.fechaAnalista = :fecha WHERE s.id = :id")
        void actualizarEstadoAnalista(@Param("id") Long id, @Param("estado") String estado,
                        @Param("observaciones") String observaciones, @Param("fecha") String fecha);

        @Modifying
        @Transactional
        @Query("UPDATE RegistrosSolicitudMaterial s SET s.aprobacionDirector = :estado, s.observacionesDirector = :observaciones, s.fechaDirector = :fecha WHERE s.id = :id")
        void actualizarEstadoDirector(@Param("id") Long id, @Param("estado") String estado,
                        @Param("observaciones") String observaciones, @Param("fecha") String fecha);

        @Modifying
        @Transactional
        @Query("UPDATE RegistrosSolicitudMaterial s SET s.aprobacionDireccionOperacion = :estado, s.observacionesDireccionOperacion = :observaciones, s.fechaDireccionOperacion = :fecha WHERE s.id = :id")
        void actualizarEstadoDireccionOperacion(@Param("id") Long id, @Param("estado") String estado,
                        @Param("observaciones") String observaciones, @Param("fecha") String fecha);

        @Modifying
        @Transactional
        @Query("UPDATE RegistrosSolicitudMaterial s SET s.entregaBodega = :estado, s.observacionesEntregaBodega = :observaciones WHERE s.id = :id")
        void actualizarEstadoEntregaBodega(@Param("id") Long id, @Param("estado") String estado,
                        @Param("observaciones") String observaciones);

        @Modifying
        @Transactional
        @Query("UPDATE RegistrosSolicitudMaterial s SET s.cantidadRestantePorDespacho = :cantidad WHERE s.id = :id")
        void actualizarEstadoCantidadRestantePorDespacho(@Param("id") Long id, @Param("cantidad") String cantidad);

        @Modifying
        @Transactional
        @Query("UPDATE RegistrosSolicitudMaterial s SET s.pdfs = :namePdfs WHERE s.id = :id")
        void actualizarEstadoEntregaBodegaPDFs(@Param("id") Long id, @Param("namePdfs") String namePdfs);

        @Modifying
        @Transactional
        @Query("UPDATE RegistrosSolicitudMaterial s SET s.cantidadDisponibleMaterial = :cantidad WHERE s.id = :id")
        void actualizarEstadoCantidadDisponibleMaterial(@Param("id") Long id, @Param("cantidad") String cantidad);

        @Modifying
        @Transactional
        @Query("UPDATE RegistrosSolicitudMaterial s SET s.estadoProyecto = :estadoProyecto WHERE s.id = :id")
        void actualizarEstadoCierreProyecto(@Param("id") Long id, @Param("estadoProyecto") String estadoProyecto);
}
