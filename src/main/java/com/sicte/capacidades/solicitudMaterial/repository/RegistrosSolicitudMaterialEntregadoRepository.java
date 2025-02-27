package com.sicte.capacidades.solicitudMaterial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.solicitudMaterial.entity.RegistrosSolicitudMaterialEntregado;

@Repository
public interface RegistrosSolicitudMaterialEntregadoRepository extends CrudRepository<RegistrosSolicitudMaterialEntregado, String> {
    public RegistrosSolicitudMaterialEntregado findByFechaEntrega(String fechaEntrega);

    public RegistrosSolicitudMaterialEntregado findByCiudad(String ciudad);

    public RegistrosSolicitudMaterialEntregado findByDocumento(String documento);

    public RegistrosSolicitudMaterialEntregado findByUuid(String uuid);

    public RegistrosSolicitudMaterialEntregado findByNombreProyecto(String nombreProyecto);

    public RegistrosSolicitudMaterialEntregado findByCodigoSapMaterial(String codigoSapMaterial);

    public RegistrosSolicitudMaterialEntregado findByDescripcionMaterial(String descripcionMaterial);

    public RegistrosSolicitudMaterialEntregado findByUnidadMedidaMaterial(String unidadMedidaMaterial);

    public RegistrosSolicitudMaterialEntregado findByCantidadSolicitadaMaterial(String cantidadSolicitadaMaterial);

    public RegistrosSolicitudMaterialEntregado findByMaterial(String material);
}
