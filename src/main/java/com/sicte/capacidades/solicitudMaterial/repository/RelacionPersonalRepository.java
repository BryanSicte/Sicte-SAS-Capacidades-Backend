package com.sicte.capacidades.solicitudMaterial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.solicitudMaterial.entity.RelacionPersonal;

@Repository
public interface RelacionPersonalRepository extends CrudRepository<RelacionPersonal, String> {
        public RelacionPersonal findByDirector(String director);

        public RelacionPersonal findByCoordinador(String coordinador);

        public RelacionPersonal findByDireccion(String direccion);

        public RelacionPersonal findBySupervisor(String supervisor);

        public RelacionPersonal findByBodega(String bodega);

        public RelacionPersonal findByCiudad(String ciudad);

        public RelacionPersonal findByAnalistaLogistica(String analistaLogistica);

        public RelacionPersonal findBySupervisorLogistica(String supervisorLogistica);

        public RelacionPersonal findByFacturacion(String facturacion);

        public RelacionPersonal findByAuxiliar(String auxiliar);
}
