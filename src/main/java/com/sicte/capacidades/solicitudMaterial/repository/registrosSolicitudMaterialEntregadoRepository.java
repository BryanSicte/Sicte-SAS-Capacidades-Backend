package com.sicte.capacidades.solicitudMaterial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.solicitudMaterial.entity.registrosSolicitudMaterialEntregado;;

@Repository
public interface registrosSolicitudMaterialEntregadoRepository extends CrudRepository<registrosSolicitudMaterialEntregado, String> {
    public registrosSolicitudMaterialEntregado findByFechaEntrega(String fechaEntrega);

    public registrosSolicitudMaterialEntregado findByCiudad(String ciudad);

    public registrosSolicitudMaterialEntregado findByDocumento(String documento);

    public registrosSolicitudMaterialEntregado findByUuid(String uuid);

    public registrosSolicitudMaterialEntregado findByNombreProyecto(String nombreProyecto);

    public registrosSolicitudMaterialEntregado findByCodigoSapMaterial(String codigoSapMaterial);

    public registrosSolicitudMaterialEntregado findByDescripcionMaterial(String descripcionMaterial);

    public registrosSolicitudMaterialEntregado findByUnidadMedidaMaterial(String unidadMedidaMaterial);

    public registrosSolicitudMaterialEntregado findByCantidadSolicitadaMaterial(String cantidadSolicitadaMaterial);

    public registrosSolicitudMaterialEntregado findByMaterial(String material);
}
