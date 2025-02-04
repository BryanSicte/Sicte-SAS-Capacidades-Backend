package com.sicte.capacidades.solicitudMaterial.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sicte.capacidades.solicitudMaterial.entity.registrosSolicitudMaterial;;

@Repository
public interface registrosSolicitudMaterialRepository extends CrudRepository<registrosSolicitudMaterial, String> {
        public registrosSolicitudMaterial findByFecha(String fecha);

        public registrosSolicitudMaterial findByCedula(String cedula);

        public registrosSolicitudMaterial findByNombre(String nombre);

        public registrosSolicitudMaterial findByCiudad(String ciudad);

        public registrosSolicitudMaterial findByDiseño(String diseño);

        public registrosSolicitudMaterial findByKmz(String kmz);

        public registrosSolicitudMaterial findByUuid(String uuid);

        public registrosSolicitudMaterial findByNombreProyecto(String nombreProyecto);

        public registrosSolicitudMaterial findByEntregaProyecto(String entregaProyecto);

        public registrosSolicitudMaterial findByPropiedadMaterial(String propiedadMaterial);

        public registrosSolicitudMaterial findByCodigoSapMaterial(String codigoSapMaterial);

        public registrosSolicitudMaterial findByDescripcionMaterial(String descripcionMaterial);

        public registrosSolicitudMaterial findByUnidadMedidaMaterial(String unidadMedidaMaterial);

        public registrosSolicitudMaterial findByCantidadDisponibleMaterial(String cantidadDisponibleMaterial);

        public registrosSolicitudMaterial findByCantidadSolicitadaMaterial(String cantidadSolicitadaMaterial);
        
        public registrosSolicitudMaterial findByCantidadRestantePorDespacho(String cantidadRestantePorDespacho);

        public registrosSolicitudMaterial findByAprobacionAnalista(String aprobacionAnalista);

        public registrosSolicitudMaterial findByFechaAnalista(String fechaAnalista);

        public registrosSolicitudMaterial findByObservacionesAnalista(String observacionesAnalista);

        public registrosSolicitudMaterial findByAprobacionDirector(String aprobacionDirector);

        public registrosSolicitudMaterial findByFechaDirector(String fechaDirector);

        public registrosSolicitudMaterial findByObservacionesDirector(String observacionesDirector);

        public registrosSolicitudMaterial findByAprobacionDireccionOperacion(String aprobacionDireccionOperacion);

        public registrosSolicitudMaterial findByFechaDireccionOperacion(String fechaDireccionOperacion);

        public registrosSolicitudMaterial findByObservacionesDireccionOperacion(String observacionesDireccionOperacion);

        public registrosSolicitudMaterial findByEntregaBodega(String entregaBodega);

        public registrosSolicitudMaterial findByObservacionesEntregaBodega(String observacionesEntregaBodega);

        public registrosSolicitudMaterial findByPdfs(String pdfs);

        public registrosSolicitudMaterial findByEstadoProyecto(String estadoProyecto);

        @Modifying
        @Transactional
        @Query("UPDATE registrosSolicitudMaterial s SET s.aprobacionAnalista = :estado, s.observacionesAnalista = :observaciones, s.fechaAnalista = :fecha WHERE s.id = :id")
        void actualizarEstadoAnalista(@Param("id") Long id, @Param("estado") String estado,
                        @Param("observaciones") String observaciones, @Param("fecha") String fecha);

        @Modifying
        @Transactional
        @Query("UPDATE registrosSolicitudMaterial s SET s.aprobacionDirector = :estado, s.observacionesDirector = :observaciones, s.fechaDirector = :fecha WHERE s.id = :id")
        void actualizarEstadoDirector(@Param("id") Long id, @Param("estado") String estado,
                        @Param("observaciones") String observaciones, @Param("fecha") String fecha);

        @Modifying
        @Transactional
        @Query("UPDATE registrosSolicitudMaterial s SET s.aprobacionDireccionOperacion = :estado, s.observacionesDireccionOperacion = :observaciones, s.fechaDireccionOperacion = :fecha WHERE s.id = :id")
        void actualizarEstadoDireccionOperacion(@Param("id") Long id, @Param("estado") String estado,
                        @Param("observaciones") String observaciones, @Param("fecha") String fecha);

        @Modifying
        @Transactional
        @Query("UPDATE registrosSolicitudMaterial s SET s.entregaBodega = :estado, s.observacionesEntregaBodega = :observaciones WHERE s.id = :id")
        void actualizarEstadoEntregaBodega(@Param("id") Long id, @Param("estado") String estado,
                        @Param("observaciones") String observaciones);

        @Modifying
        @Transactional
        @Query("UPDATE registrosSolicitudMaterial s SET s.cantidadRestantePorDespacho = :cantidad WHERE s.id = :id")
        void actualizarEstadoCantidadRestantePorDespacho(@Param("id") Long id, @Param("cantidad") String cantidad);

        @Modifying
        @Transactional
        @Query("UPDATE registrosSolicitudMaterial s SET s.pdfs = :namePdfs WHERE s.id = :id")
        void actualizarEstadoEntregaBodegaPDFs(@Param("id") Long id, @Param("namePdfs") String namePdfs);

        @Modifying
        @Transactional
        @Query("UPDATE registrosSolicitudMaterial s SET s.cantidadDisponibleMaterial = :cantidad WHERE s.id = :id")
        void actualizarEstadoCantidadDisponibleMaterial(@Param("id") Long id, @Param("cantidad") String cantidad);

        @Modifying
        @Transactional
        @Query("UPDATE registrosSolicitudMaterial s SET s.estadoProyecto = :estadoProyecto WHERE s.id = :id")
        void actualizarEstadoCierreProyecto(@Param("id") Long id, @Param("estadoProyecto") String estadoProyecto);
}
