package com.sicte.capacidades.reporteMaterialFerretero.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.reporteMaterialFerretero.entity.reporteMaterial;

@Repository
public interface reporteMaterialRepository extends CrudRepository<reporteMaterial, String> {
        public reporteMaterial findByFecha(String fecha);

        public reporteMaterial findByCedula(String cedula);

        public reporteMaterial findByNombre(String nombre);

        public reporteMaterial findByOt(String ot);

        public reporteMaterial findByCodigoMovil(String codigoMovil);

        public reporteMaterial findByMovil(String movil);

        public reporteMaterial findByResponsable(String responsable);

        public reporteMaterial findByNodo(String nodo);

        public reporteMaterial findByCodigoSap(String codigoSap);

        public reporteMaterial findByDescripcion(String descripcion);

        public reporteMaterial findByUnidadMedida(String unidadMedida);

        public reporteMaterial findByCantidad(String cantidad);

        public reporteMaterial findBySerial(String serial);

        public reporteMaterial findByFirma(String firma);
}
