package com.sicte.capacidades.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.usuarios.entity.pagesUser;

@Repository
public interface pagesUserRepository extends CrudRepository<pagesUser, String> {

    public pagesUser findByCedula(String cedula);
    public pagesUser findByReportesCapacidades(String reportesCapacidades);
    public pagesUser findByReportesSupervision(String reportesSupervision);
    public pagesUser findByFacturacionConsolidadoNacional(String facturacionConsolidadoNacional);
    public pagesUser findByFacturacionProyectos(String facturacionProyectos);
    public pagesUser findByFacturacionCorporativo(String facturacionCorporativo);
    public pagesUser findByFacturacionMantenimiento(String facturacionMantenimiento);
    public pagesUser findByFacturacionOperaciones(String facturacionOperaciones);
    public pagesUser findByFacturacionMintic(String facturacionMintic);
    public pagesUser findByFacturacionSmu(String facturacionSmu);
    public pagesUser findByFacturacionImplementacionMovil(String facturacionImplementacionMovil);
    public pagesUser findByFacturacionMedicionesMovil(String facturacionMedicionesMovil);
    public pagesUser findByFacturacionObraCivilMovil(String facturacionObraCivilMovil);
    public pagesUser findByProducionNacional(String producionNacional);
    public pagesUser findByProducionProyectos(String producionProyectos);
    public pagesUser findByProducionCorporativo(String producionCorporativo);
    public pagesUser findByProducionMantenimiento(String producionMantenimiento);
    public pagesUser findByProducionReingenierias(String producionReingenierias);
    public pagesUser findByProducionOperaciones(String producionOperaciones);
    public pagesUser findByIndicadoresHistoricoKpi(String indicadoresHistoricoKpi);
    public pagesUser findByIndicadoresG1Mantenimiento(String indicadoresG1Mantenimiento);
    public pagesUser findByIndicadoresNps(String indicadoresNps);
    public pagesUser findBySstaSsta(String sstaSsta);
    public pagesUser findBySstaCursoDeAlturas(String sstaCursoDeAlturas);
    public pagesUser findBySstaEntregasPendientesDotacion(String sstaEntregasPendientesDotacion);
    public pagesUser findByPuntuacionProyectos(String puntuacionProyectos);
    public pagesUser findByPuntuacionCorporativo(String puntuacionCorporativo);
    public pagesUser findByPuntuacionMantenimiento(String puntuacionMantenimiento);
    public pagesUser findByPuntuacionReingenierias(String puntuacionReingenierias);
    public pagesUser findByOperacionCumplimientoSlaFo(String operacionCumplimientoSlaFo);
    public pagesUser findByOperacionCumplimientoSlaHfc(String operacionCumplimientoSlaHfc);
    public pagesUser findByOperacionCorrectivoPreventivo(String operacionCorrectivoPreventivo);
    public pagesUser findByOperacionSeguimientoMttoCentro(String operacionSeguimientoMttoCentro);
    public pagesUser findByOperacionSeguimientoOperaciones(String operacionSeguimientoOperaciones);
    public pagesUser findByOperacionSeguimientoSmu(String operacionSeguimientoSmu);
    public pagesUser findByOperacionTecnicoSmu(String operacionTecnicoSmu);
    public pagesUser findByOperacionTorreDeControl(String operacionTorreDeControl);
    public pagesUser findByLogisticaEquiposEnMovilesR2(String logisticaEquiposEnMovilesR2);
    public pagesUser findByLogisticaEquiposEnMovilesR4(String logisticaEquiposEnMovilesR4);
    public pagesUser findByLogisticaConsumosOperaciones(String logisticaConsumosOperaciones);
    public pagesUser findByLogisticaDesmonteMantenimiento(String logisticaDesmonteMantenimiento);
    public pagesUser findByLogisticaSolicitudDeMaterial(String logisticaSolicitudDeMaterial);
    public pagesUser findByLogisticaReporteMaterialFerretero(String logisticaReporteMaterialFerretero);
    public pagesUser findByLogisticaInventarioMaterial(String logisticaInventarioMaterial);
    public pagesUser findByLogisticaEstadoProyectosR4(String logisticaEstadoProyectosR4);
    public pagesUser findByDireccionPenalizaciones(String direccionPenalizaciones);
    public pagesUser findByDireccionCentroDeCostos(String direccionCentroDeCostos);
    public pagesUser findByDireccionComposicionMoviles(String direccionComposicionMoviles);
    public pagesUser findByDireccionCompras(String direccionCompras);
}
