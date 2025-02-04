package com.sicte.capacidades.inventarioMaterial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.inventarioMaterial.entity.inventarioMaterial;

@Repository
public interface inventarioMaterialRepository extends CrudRepository<inventarioMaterial, String> {
        public inventarioMaterial findByFecha(String fecha);

        public inventarioMaterial findByCedula(String cedula);

        public inventarioMaterial findByNombre(String nombre);

        public inventarioMaterial findByCodigoMovil(String codigoMovil);
        
        public inventarioMaterial findByMovil(String movil);

        public inventarioMaterial findByResponsable(String responsable);

        public inventarioMaterial findByCodigoSap(String codigoSap);

        public inventarioMaterial findByDescripcion(String descripcion);

        public inventarioMaterial findByUnidadMedida(String unidadMedida);

        public inventarioMaterial findByCantidad(String cantidad);

        public inventarioMaterial findBySerial(String serial);
}
