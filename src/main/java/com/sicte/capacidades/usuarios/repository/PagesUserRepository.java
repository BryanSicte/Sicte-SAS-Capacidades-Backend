package com.sicte.capacidades.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.usuarios.entity.PagesUser;

@Repository
public interface PagesUserRepository extends CrudRepository<PagesUser, String> {

    public PagesUser findByCedula(String cedula);

    public PagesUser findByReportesCapacidades(String reportesCapacidades);

    public PagesUser findByReportesSupervision(String reportesSupervision);

    public PagesUser findByFacturacionConsolidadoNacional(String facturacionConsolidadoNacional);

    public PagesUser findByFacturacionProyectos(String facturacionProyectos);

    public PagesUser findByFacturacionCorporativo(String facturacionCorporativo);

    public PagesUser findByFacturacionMantenimiento(String facturacionMantenimiento);

    public PagesUser findByFacturacionOperaciones(String facturacionOperaciones);

    public PagesUser findByFacturacionMintic(String facturacionMintic);

    public PagesUser findByFacturacionSmu(String facturacionSmu);

    public PagesUser findByFacturacionImplementacionMovil(String facturacionImplementacionMovil);

    public PagesUser findByFacturacionMedicionesMovil(String facturacionMedicionesMovil);

    public PagesUser findByFacturacionObraCivilMovil(String facturacionObraCivilMovil);

    public PagesUser findByProducionNacional(String producionNacional);

    public PagesUser findByProducionProyectos(String producionProyectos);

    public PagesUser findByProducionCorporativo(String producionCorporativo);

    public PagesUser findByProducionMantenimiento(String producionMantenimiento);

    public PagesUser findByProducionReingenierias(String producionReingenierias);

    public PagesUser findByProducionOperaciones(String producionOperaciones);

    public PagesUser findByIndicadoresHistoricoKpi(String indicadoresHistoricoKpi);

    public PagesUser findByIndicadoresG1Mantenimiento(String indicadoresG1Mantenimiento);

    public PagesUser findByIndicadoresNps(String indicadoresNps);

    public PagesUser findByIndicadoresG2G8MasivoCentro(String indicadoresG2G8MasivoCentro);

    public PagesUser findBySstaSsta(String sstaSsta);

    public PagesUser findBySstaCursoDeAlturas(String sstaCursoDeAlturas);

    public PagesUser findBySstaEntregasPendientesDotacion(String sstaEntregasPendientesDotacion);

    public PagesUser findByPuntuacionProyectos(String puntuacionProyectos);

    public PagesUser findByPuntuacionCorporativo(String puntuacionCorporativo);

    public PagesUser findByPuntuacionMantenimiento(String puntuacionMantenimiento);

    public PagesUser findByPuntuacionReingenierias(String puntuacionReingenierias);

    public PagesUser findByOperacionCumplimientoSlaFo(String operacionCumplimientoSlaFo);

    public PagesUser findByOperacionCumplimientoSlaHfc(String operacionCumplimientoSlaHfc);

    public PagesUser findByOperacionCorrectivoPreventivo(String operacionCorrectivoPreventivo);

    public PagesUser findByOperacionRecursoOperaciones(String operacionRecursoOperaciones);

    public PagesUser findByOperacionSeguimientoMttoCentro(String operacionSeguimientoMttoCentro);

    public PagesUser findByOperacionSeguimientoOperacionesCentro(String operacionSeguimientoOperacionesCentro);

    public PagesUser findByOperacionSeguimientoOperacionesNorte(String operacionSeguimientoOperacionesNorte);

    public PagesUser findByOperacionSeguimientoSmu(String operacionSeguimientoSmu);

    public PagesUser findByOperacionTecnicoSmu(String operacionTecnicoSmu);

    public PagesUser findByOperacionTorreDeControl(String operacionTorreDeControl);

    public PagesUser findByLogisticaEquiposEnMovilesR2(String logisticaEquiposEnMovilesR2);

    public PagesUser findByLogisticaEquiposEnMovilesR4(String logisticaEquiposEnMovilesR4);

    public PagesUser findByLogisticaConsumosOperaciones(String logisticaConsumosOperaciones);

    public PagesUser findByLogisticaDesmonteMantenimiento(String logisticaDesmonteMantenimiento);

    public PagesUser findByLogisticaSolicitudDeMaterial(String logisticaSolicitudDeMaterial);

    public PagesUser findByLogisticaReporteMaterialFerretero(String logisticaReporteMaterialFerretero);

    public PagesUser findByLogisticaInventarioMaterial(String logisticaInventarioMaterial);

    public PagesUser findByLogisticaEstadoProyectosR4(String logisticaEstadoProyectosR4);

    public PagesUser findByDireccionPenalizaciones(String direccionPenalizaciones);

    public PagesUser findByDireccionCentroDeCostos(String direccionCentroDeCostos);

    public PagesUser findByDireccionComposicionMoviles(String direccionComposicionMoviles);

    public PagesUser findByDireccionCompras(String direccionCompras);

    public PagesUser findByParqueAutomotorMoviles(String parqueAutomotorMoviles);

    public PagesUser findByGestionHumanaChatbot(String gestionHumanaChatbot);

    public PagesUser findByGestionHumanaCarnetizacion(String gestionHumanaCarnetizacion);
}
