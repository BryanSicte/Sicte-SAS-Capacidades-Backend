package com.sicte.capacidades.inventarioMaterial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.inventarioMaterial.entity.InventarioMaterial;

@Repository
public interface InventarioMaterialRepository extends CrudRepository<InventarioMaterial, String> {
        public InventarioMaterial findByFecha(String fecha);

        public InventarioMaterial findByCedula(String cedula);

        public InventarioMaterial findByNombre(String nombre);

        public InventarioMaterial findByCodigoMovil(String codigoMovil);
        
        public InventarioMaterial findByMovil(String movil);

        public InventarioMaterial findByResponsable(String responsable);

        public InventarioMaterial findByCodigoSap(String codigoSap);

        public InventarioMaterial findByDescripcion(String descripcion);

        public InventarioMaterial findByUnidadMedida(String unidadMedida);

        public InventarioMaterial findByCantidad(String cantidad);

        public InventarioMaterial findBySerial(String serial);
}
