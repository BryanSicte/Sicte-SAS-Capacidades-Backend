package com.sicte.capacidades.usuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "pages_per_user")
@NoArgsConstructor
@AllArgsConstructor
public class PagesUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Cedula")
    private String cedula;
    @Column(name = "Reportes Capacidades")
    private String reportesCapacidades;
    @Column(name = "Reportes Supervision")
    private String reportesSupervision;
    @Column(name = "Facturacion Consolidado Nacional")
    private String facturacionConsolidadoNacional;
    @Column(name = "Facturacion Proyectos")
    private String facturacionProyectos;
    @Column(name = "Facturacion Corporativo")
    private String facturacionCorporativo;
    @Column(name = "Facturacion Mantenimiento")
    private String facturacionMantenimiento;
    @Column(name = "Facturacion Operaciones")
    private String facturacionOperaciones;
    @Column(name = "Facturacion Mintic")
    private String facturacionMintic;
    @Column(name = "Facturacion Smu")
    private String facturacionSmu;
    @Column(name = "Facturacion Implementacion Movil")
    private String facturacionImplementacionMovil;
    @Column(name = "Facturacion Mediciones Movil")
    private String facturacionMedicionesMovil;
    @Column(name = "Facturacion Obra Civil Movil")
    private String facturacionObraCivilMovil;
    @Column(name = "Producion Nacional")
    private String producionNacional;
    @Column(name = "Producion Proyectos")
    private String producionProyectos;
    @Column(name = "Producion Corporativo")
    private String producionCorporativo;
    @Column(name = "Producion Mantenimiento")
    private String producionMantenimiento;
    @Column(name = "Producion Reingenierias")
    private String producionReingenierias;
    @Column(name = "Producion Operaciones")
    private String producionOperaciones;
    @Column(name = "Indicadores Historico Kpi")
    private String indicadoresHistoricoKpi;
    @Column(name = "Indicadores G1 Mantenimiento")
    private String indicadoresG1Mantenimiento;
    @Column(name = "Indicadores Nps")
    private String indicadoresNps;
    @Column(name = "Ssta Ssta")
    private String sstaSsta;
    @Column(name = "Ssta Curso De Alturas")
    private String sstaCursoDeAlturas;
    @Column(name = "Ssta Entregas Pendientes Dotacion")
    private String sstaEntregasPendientesDotacion;
    @Column(name = "Puntuacion Proyectos")
    private String puntuacionProyectos;
    @Column(name = "Puntuacion Corporativo")
    private String puntuacionCorporativo;
    @Column(name = "Puntuacion Mantenimiento")
    private String puntuacionMantenimiento;
    @Column(name = "Puntuacion Reingenierias")
    private String puntuacionReingenierias;
    @Column(name = "Operacion Cumplimiento Sla Fo")
    private String operacionCumplimientoSlaFo;
    @Column(name = "Operacion Cumplimiento Sla Hfc")
    private String operacionCumplimientoSlaHfc;
    @Column(name = "Operacion Correctivo Preventivo")
    private String operacionCorrectivoPreventivo;
    @Column(name = "Operacion Seguimiento Mtto Centro")
    private String operacionSeguimientoMttoCentro;
    @Column(name = "Operacion Seguimiento Operaciones")
    private String operacionSeguimientoOperaciones;
    @Column(name = "Operacion Seguimiento Smu")
    private String operacionSeguimientoSmu;
    @Column(name = "Operacion Tecnico Smu")
    private String operacionTecnicoSmu;
    @Column(name = "Operacion Torre De Control")
    private String operacionTorreDeControl;
    @Column(name = "Logistica Equipos En Moviles R2")
    private String logisticaEquiposEnMovilesR2;
    @Column(name = "Logistica Equipos En Moviles R4")
    private String logisticaEquiposEnMovilesR4;
    @Column(name = "Logistica Consumos Operaciones")
    private String logisticaConsumosOperaciones;
    @Column(name = "Logistica Desmonte Mantenimiento")
    private String logisticaDesmonteMantenimiento;
    @Column(name = "Logistica Solicitud De Material")
    private String logisticaSolicitudDeMaterial;
    @Column(name = "Logistica Reporte Material Ferretero")
    private String logisticaReporteMaterialFerretero;
    @Column(name = "Logistica Inventario Material")
    private String logisticaInventarioMaterial;
    @Column(name = "Logistica Estado Proyectos R4")
    private String logisticaEstadoProyectosR4;
    @Column(name = "Direccion Penalizaciones")
    private String direccionPenalizaciones;
    @Column(name = "Direccion Centro De Costos")
    private String direccionCentroDeCostos;
    @Column(name = "Direccion Composicion Moviles")
    private String direccionComposicionMoviles;
    @Column(name = "Direccion Compras")
    private String direccionCompras;
}