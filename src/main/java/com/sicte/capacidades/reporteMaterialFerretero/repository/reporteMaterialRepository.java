package com.sicte.capacidades.reporteMaterialFerretero.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.reporteMaterialFerretero.entity.ReporteMaterial;

@Repository
public interface ReporteMaterialRepository extends CrudRepository<ReporteMaterial, String> {
        public ReporteMaterial findByFecha(String fecha);

        public ReporteMaterial findByCedula(String cedula);

        public ReporteMaterial findByNombre(String nombre);

        public ReporteMaterial findByOt(String ot);

        public ReporteMaterial findByCodigoMovil(String codigoMovil);

        public ReporteMaterial findByMovil(String movil);

        public ReporteMaterial findByResponsable(String responsable);

        public ReporteMaterial findByNodo(String nodo);

        public ReporteMaterial findByCodigoSap(String codigoSap);

        public ReporteMaterial findByDescripcion(String descripcion);

        public ReporteMaterial findByUnidadMedida(String unidadMedida);

        public ReporteMaterial findByCantidad(String cantidad);

        public ReporteMaterial findBySerial(String serial);

        public ReporteMaterial findByFirma(String firma);
}
