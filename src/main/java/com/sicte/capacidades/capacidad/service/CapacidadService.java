package com.sicte.capacidades.capacidad.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.capacidad.dto.CedulaNombreDto;
import com.sicte.capacidades.capacidad.entity.AgregarPersonal;
import com.sicte.capacidades.capacidad.entity.Capacidad;
import com.sicte.capacidades.capacidad.entity.CapacidadBackup;
import com.sicte.capacidades.capacidad.entity.Ciudad;
import com.sicte.capacidades.capacidad.entity.Coordinador;
import com.sicte.capacidades.capacidad.entity.Movil;
import com.sicte.capacidades.capacidad.entity.Planta;
import com.sicte.capacidades.capacidad.entity.PlantaEnLinea;
import com.sicte.capacidades.capacidad.repository.CapacidadBackupRepository;
import com.sicte.capacidades.capacidad.repository.CapacidadRepository;
import com.sicte.capacidades.capacidad.repository.CiudadRepository;
import com.sicte.capacidades.capacidad.repository.coordinadorRepository;
import com.sicte.capacidades.capacidad.repository.MovilRepository;
import com.sicte.capacidades.capacidad.repository.PlantaEnLineaRepository;
import com.sicte.capacidades.capacidad.repository.PlantaRepository;

@Service
public class CapacidadService{
    @Autowired
    CapacidadBackupRepository capacidadBackupRepository;
    @Autowired
    CapacidadRepository capacidadRepository;
    @Autowired
    PlantaRepository plantaRepository;
    @Autowired
    PlantaEnLineaRepository plantaEnLineaRepository;
    @Autowired
    CiudadRepository ciudadRepository;
    @Autowired
    coordinadorRepository coordinadorRepository;
    @Autowired
    MovilRepository movilRepository;

    public CapacidadBackup save(CapacidadBackup capacidad) {
        return capacidadBackupRepository.save(capacidad);
    }

    public Capacidad guardarCapacidad(Capacidad capacidad) {
        return capacidadRepository.save(capacidad);
    }

    public List<CapacidadBackup> encontrarTodoCapacidadBackup() {
        return (List<CapacidadBackup>) capacidadBackupRepository.findAllOrderByFechaReporteDesc();
    }

    public List<Capacidad> encontrarTodoCapacidad(String role) {
        List<Capacidad> capacidades = (List<Capacidad>) capacidadRepository.findAllOrderByFechaReporteDesc();
        List<Capacidad> registrosCoincidentes = new ArrayList<>();
        if (!"admin".equalsIgnoreCase(role)) {
            registrosCoincidentes = filtrarPorRolDirectorCapacidades(capacidades, role);
        } else {
            registrosCoincidentes = capacidades;
        }
        return registrosCoincidentes;
    }

    private List<Capacidad> filtrarPorRolDirectorCapacidades(List<Capacidad> registros, String director) {
        // Filtrar registros por la columna 'director'
        return registros.stream()
                .filter(capacidad -> director.equals(capacidad.getDirector()))
                .collect(Collectors.toList());
    }

    public List<Movil> encontrarTodoMovil() {
        return (List<Movil>) movilRepository.findAll();
    }

    public List<Coordinador> encontrarTodoCoordinador() {
        return (List<Coordinador>) coordinadorRepository.findAll();
    } 

    public List<Planta> encontrarTodoPlanta() {
        return (List<Planta>) plantaRepository.findAll();
    }

    public List<PlantaEnLinea> encontrarTodoPlantaEnLinea() {
        return (List<PlantaEnLinea>) plantaEnLineaRepository.findAll();
    }

    public List<CedulaNombreDto> encontrarCedulaYNombrePlantaEnLinea() {
        return plantaEnLineaRepository.findCedulaAndNombre();
    }

    public List<CapacidadBackup> encontrarTodoUltimoMes() {
        // Obtener todos los registros
        List<CapacidadBackup> todosLosRegistros = (List<CapacidadBackup>) capacidadBackupRepository.findAllOrderByFechaReporteDesc();

        // Encontrar el último mes presente en los datos
        Optional<LocalDate> ultimaFecha = todosLosRegistros.stream()
            .map(CapacidadBackup::getFechaReporte)
            .map(this::parseLocalDate) // Convertir las cadenas de fecha a LocalDate
            .max(Comparator.naturalOrder());

        // Verificar si se encontró una última fecha
        if (ultimaFecha.isPresent()) {
            // Obtener el año y mes de la última fecha encontrada
            YearMonth ultimoMes = YearMonth.from(ultimaFecha.get());

            // Obtener la fecha del primer día del último mes
            LocalDate primerDiaUltimoMes = ultimoMes.atDay(1);

            // Obtener la fecha del primer día del siguiente mes
            LocalDate primerDiaSiguienteMes = ultimoMes.plusMonths(1).atDay(1);

            // Filtrar los registros por el rango de fechas del último mes
            return  todosLosRegistros.stream()
                .filter(capacidad -> {
                    LocalDate fecha = parseLocalDate(capacidad.getFechaReporte());
                    return !fecha.isBefore(primerDiaUltimoMes) && fecha.isBefore(primerDiaSiguienteMes);
                })
                .collect(Collectors.toList());
        } else {
            // Si no se encuentra ninguna fecha de reporte, devolver una lista vacía
            return List.of();
        }
    }

    // Método para convertir cadenas de fecha a LocalDate
    private LocalDate parseLocalDate(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDate.parse(fecha, formatter);
    }

    public List<CapacidadBackup> encontrarTodoContinuaEnPlanta(String role) {
        List<Planta> todosLosRegistrosPlanta = (List<Planta>) plantaRepository.findAll();
        List<Capacidad> capacidades = (List<Capacidad>) capacidadRepository.findAll();
        Map<String, CapacidadBackup> capacidadPorCedula = new HashMap<String, CapacidadBackup>();
        
        List<CapacidadBackup> todasLasCapacidades = (List<CapacidadBackup>) encontrarTodoUltimoMes();
        for (CapacidadBackup capacidad : todasLasCapacidades) {
            capacidadPorCedula.put(capacidad.getCedula(), capacidad);
        }

        List<String> cedulasExistentes = new ArrayList<>();
        for (Capacidad capacidad : capacidades) {
            cedulasExistentes.add(capacidad.getCedula());
        }

        List<CapacidadBackup> registrosCoincidentes = new ArrayList<>();
        for (Planta planta : todosLosRegistrosPlanta) {
            CapacidadBackup capacidad = capacidadPorCedula.get(planta.getNit());
            if (capacidad != null && !cedulasExistentes.contains(capacidad.getCedula())) {
                registrosCoincidentes.add(capacidad);
            }
        }
        
        if (!"admin".equalsIgnoreCase(role)) {
            registrosCoincidentes = filtrarPorRolDirectorCapacidadesBackup(registrosCoincidentes, role);
        }

        Collections.shuffle(registrosCoincidentes);
        return registrosCoincidentes;
    }

    public List<Planta> encontrarPlantasSinCapacidad(String role) {
        List<Planta> todosLosRegistrosPlanta = (List<Planta>) plantaRepository.findAll();
        List<Capacidad> capacidades = (List<Capacidad>) capacidadRepository.findAll();

        List<String> cedulasExistentes = new ArrayList<>();
        for (Capacidad capacidad : capacidades) {
            cedulasExistentes.add(capacidad.getCedula());
        }

        List<Planta> plantasSinCapacidad = new ArrayList<>();
        for (Planta planta : todosLosRegistrosPlanta) {
            if (!cedulasExistentes.contains(planta.getNit())) {
                plantasSinCapacidad.add(planta);
            }
        }

        if (!"admin".equalsIgnoreCase(role)) {
            String roll;
            if ("JOHANA CARVAJAL".equalsIgnoreCase(role)) {
                roll = "JOHANNA CARVAJAL";
            } else {
                roll = role;
            }

            plantasSinCapacidad = filtrarPorRolDirectorPlanta(plantasSinCapacidad, roll);
        }

        Collections.shuffle(plantasSinCapacidad);
        return plantasSinCapacidad;
    }

    private List<CapacidadBackup> filtrarPorRolDirectorCapacidadesBackup(List<CapacidadBackup> registros, String director) {
        // Filtrar registros por la columna 'director'
        return registros.stream()
                .filter(capacidad -> director.equals(capacidad.getDirector()))
                .collect(Collectors.toList());
    }

    private List<Planta> filtrarPorRolDirectorPlanta(List<Planta> plantas, String director) {
        // Implementa la lógica de filtrado basada en el rol del director aquí
        // Este es un método de ejemplo
        return plantas.stream()
                .filter(planta -> director.equals(planta.getDirector()))
                .collect(Collectors.toList());
    }

    public List<CapacidadBackup> encontrarTodoNoContinuaEnPlanta() {
        List<Planta> todosLosRegistrosPlanta = (List<Planta>) plantaRepository.findAll();
        List<CapacidadBackup> capacidadesNoCoincidentes = new ArrayList<>();
        Set<String> cedulasAgregadas = new HashSet<>();

        // Obtener todos los NITs de la planta
        Set<String> nitsPlanta = todosLosRegistrosPlanta.stream()
                                                        .map(Planta::getNit)
                                                        .collect(Collectors.toSet());

        // Encontrar las capacidades que no tienen un NIT correspondiente en la planta
        for (CapacidadBackup capacidad : capacidadBackupRepository.findAllOrderByFechaReporteDesc()) {
            String cedula = capacidad.getCedula();
            if (!nitsPlanta.contains(cedula) && !cedulasAgregadas.contains(cedula)) {
                capacidadesNoCoincidentes.add(capacidad);
                cedulasAgregadas.add(cedula);
            }
        }

        Collections.shuffle(capacidadesNoCoincidentes);

        return capacidadesNoCoincidentes;
    }

    public Map<String, Object> obtenerInformacionValidarPersonal (AgregarPersonal personal) {
        System.err.println(personal);
        Planta informacionPlanta = plantaRepository.findByNit(personal.getCedula());
        System.err.println(informacionPlanta);
        Ciudad informacionCiudad = ciudadRepository.findByCiudad(informacionPlanta.getCiudad());
        System.err.println(informacionCiudad);
        Coordinador informacionCoordinador = coordinadorRepository.findByCoordinador(personal.getCoordinador());
        System.err.println(informacionCoordinador);
        Movil informacionMovil = movilRepository.findByTipoMovil(personal.getTipoMovil());
        System.err.println(informacionMovil);
        String fechaReporteStr = obtenerFechaReporte();

        Map<String, Object> response = new HashMap<>();
        response.put("cedula", personal.getCedula());
        response.put("nombre", informacionPlanta.getNombre());
        response.put("cargo", informacionPlanta.getCargo());

        String cc = informacionPlanta.getCc();
        String scc = informacionPlanta.getScc();
        String numeroUnificado = "";
        if (cc.length() == 2) {
            String sccStr = String.format("%03d", Integer.parseInt(scc));        
            numeroUnificado = cc + sccStr;
        } else if (cc.length() == 1) {
            String sccStr = String.format("%04d", Integer.parseInt(scc));        
            numeroUnificado = cc + sccStr;
        }
        
        response.put("centroCosto", numeroUnificado);
        response.put("nomina", informacionPlanta.getPerfil());
        response.put("regional", informacionCiudad.getRegional());
        response.put("ciudad", informacionPlanta.getCiudad());
        response.put("red", informacionCoordinador.getRed());
        response.put("cliente", informacionCoordinador.getCliente());
        response.put("area", informacionCoordinador.getArea());
        response.put("subarea", informacionCoordinador.getSubarea());
        response.put("tipoMovil", personal.getTipoMovil());
        response.put("tipoFacturacion", personal.getTipoFacturacion());
        response.put("movil", informacionMovil.getMovil());
        response.put("coordinador", personal.getCoordinador());
        response.put("director", informacionCoordinador.getDirector());
        response.put("valorEsperado", informacionMovil.getValorEsperado());
        response.put("placa", personal.getPlaca());
        response.put("fechaReporte", fechaReporteStr);

        LocalDateTime fechaReporte = LocalDateTime.parse(fechaReporteStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        response.put("mes", fechaReporte.getMonthValue());
        response.put("año", fechaReporte.getYear());
        response.put("turnos", informacionMovil.getTurnos());
        response.put("personas", informacionMovil.getPersonas());

        response.put("carpeta", personal.getCarpeta());
        
        return response;
    }

    public String obtenerFechaReporte() {
        LocalDateTime hoy = LocalDateTime.now();
        
        // Siempre obtener el primer día del mes actual
        LocalDateTime fechaReporte = hoy.withDayOfMonth(1);
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaReporte.format(formatter);
    }

    public void eliminarFilasPorCedula(String cedula) {
        capacidadRepository.deleteByCedula(cedula);
    }

    public Map<String, Object> obtenerInformacionAgregarPersonal (AgregarPersonal personal) {
        System.err.println(personal);
        Planta informacionPlanta = plantaRepository.findByNit(personal.getCedula());
        System.err.println(informacionPlanta);
        Ciudad informacionCiudad = ciudadRepository.findByCiudad(informacionPlanta.getCiudad());
        System.err.println(informacionCiudad);
        Coordinador informacionCoordinador = coordinadorRepository.findByCoordinador(personal.getCoordinador());
        System.err.println(informacionCoordinador);
        Movil informacionMovil = movilRepository.findByTipoMovil(personal.getTipoMovil());
        System.err.println(informacionMovil);
        String fechaReporteStr = obtenerFechaReporteAgregar();

        Map<String, Object> response = new HashMap<>();
        response.put("cedula", personal.getCedula());
        response.put("nombre", informacionPlanta.getNombre());
        response.put("cargo", informacionPlanta.getCargo());

        String cc = informacionPlanta.getCc();
        String scc = informacionPlanta.getScc();
        String numeroUnificado = "";
        if (cc.length() == 2) {
            String sccStr = String.format("%03d", Integer.parseInt(scc));        
            numeroUnificado = cc + sccStr;
        } else if (cc.length() == 1) {
            String sccStr = String.format("%04d", Integer.parseInt(scc));        
            numeroUnificado = cc + sccStr;
        }
        
        response.put("centroCosto", numeroUnificado);
        response.put("nomina", informacionPlanta.getPerfil());
        response.put("regional", informacionCiudad.getRegional());
        response.put("ciudad", informacionPlanta.getCiudad());
        response.put("red", informacionCoordinador.getRed());
        response.put("cliente", informacionCoordinador.getCliente());
        response.put("area", informacionCoordinador.getArea());
        response.put("subarea", informacionCoordinador.getSubarea());
        response.put("tipoMovil", personal.getTipoMovil());
        response.put("tipoFacturacion", personal.getTipoFacturacion());
        response.put("movil", informacionMovil.getMovil());
        response.put("coordinador", personal.getCoordinador());
        response.put("director", informacionCoordinador.getDirector());
        response.put("valorEsperado", informacionMovil.getValorEsperado());
        response.put("placa", personal.getPlaca());
        response.put("fechaReporte", fechaReporteStr);

        LocalDateTime fechaReporte = LocalDateTime.parse(fechaReporteStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        response.put("mes", fechaReporte.getMonthValue());
        response.put("año", fechaReporte.getYear());
        response.put("turnos", informacionMovil.getTurnos());
        response.put("personas", informacionMovil.getPersonas());

        response.put("carpeta", personal.getCarpeta());
        
        return response;
    }

    public String obtenerFechaReporteAgregar() {
        LocalDateTime hoy = LocalDateTime.now();
        
        // Siempre obtener el primer día del mes actual
        LocalDateTime fechaReporte = hoy.withDayOfMonth(2);
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaReporte.format(formatter);
    }
}
