package com.sicte.capacidades.solicitudMaterial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.solicitudMaterial.entity.relacionPersonal;;

@Repository
public interface relacionPersonalRepository extends CrudRepository<relacionPersonal, String> {
        public relacionPersonal findByDirector(String director);

        public relacionPersonal findByCoordinador(String coordinador);

        public relacionPersonal findByDireccion(String direccion);

        public relacionPersonal findBySupervisor(String supervisor);

        public relacionPersonal findByBodega(String bodega);

        public relacionPersonal findByCiudad(String ciudad);

        public relacionPersonal findByAnalistaLogistica(String analistaLogistica);

        public relacionPersonal findBySupervisorLogistica(String supervisorLogistica);

        public relacionPersonal findByFacturacion(String facturacion);
}
