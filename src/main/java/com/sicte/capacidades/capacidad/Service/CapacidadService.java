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

import com.sicte.capacidades.capacidad.dto.cedulaNombreDto;
import com.sicte.capacidades.capacidad.entity.agregarPersonal;
import com.sicte.capacidades.capacidad.entity.capacidad;
import com.sicte.capacidades.capacidad.entity.capacidadBackup;
import com.sicte.capacidades.capacidad.entity.ciudad;
import com.sicte.capacidades.capacidad.entity.coordinador;
import com.sicte.capacidades.capacidad.entity.movil;
import com.sicte.capacidades.capacidad.entity.planta;
import com.sicte.capacidades.capacidad.entity.plantaEnLinea;
import com.sicte.capacidades.capacidad.repository.capacidadBackupRepository;
import com.sicte.capacidades.capacidad.repository.capacidadRepository;
import com.sicte.capacidades.capacidad.repository.ciudadRepository;
import com.sicte.capacidades.capacidad.repository.coordinadorRepository;
import com.sicte.capacidades.capacidad.repository.movilRepository;
import com.sicte.capacidades.capacidad.repository.plantaEnLineaRepository;
import com.sicte.capacidades.capacidad.repository.plantaRepository;

@Service
public class capacidadService{
    @Autowired
    capacidadBackupRepository capacidadBackupRepository;
    @Autowired
    capacidadRepository capacidadRepository;
    @Autowired
    plantaRepository plantaRepository;
    @Autowired
    plantaEnLineaRepository plantaEnLineaRepository;
    @Autowired
    ciudadRepository ciudadRepository;
    @Autowired
    coordinadorRepository coordinadorRepository;
    @Autowired
    movilRepository movilRepository;

    public capacidadBackup save(capacidadBackup capacidad) {
        return capacidadBackupRepository.save(capacidad);
    }

    public capacidad guardarCapacidad(capacidad capacidad) {
        return capacidadRepository.save(capacidad);
    }

    public List<capacidadBackup> encontrarTodoCapacidadBackup() {
        return (List<capacidadBackup>) capacidadBackupRepository.findAllOrderByFechaReporteDesc();
    }

    public List<capacidad> encontrarTodoCapacidad(String role) {
        List<capacidad> capacidades = (List<capacidad>) capacidadRepository.findAllOrderByFechaReporteDesc();
        List<capacidad> registrosCoincidentes = new ArrayList<>();
        if (!"admin".equalsIgnoreCase(role)) {
            registrosCoincidentes = filtrarPorRolDirectorCapacidades(capacidades, role);
        } else {
            registrosCoincidentes = capacidades;
        }
        return registrosCoincidentes;
    }

    private List<capacidad> filtrarPorRolDirectorCapacidades(List<capacidad> registros, String director) {
        // Filtrar registros por la columna 'director'
        return registros.stream()
                .filter(capacidad -> director.equals(capacidad.getDirector()))
                .collect(Collectors.toList());
    }

    public List<movil> encontrarTodoMovil() {
        return (List<movil>) movilRepository.findAll();
    }

    public List<coordinador> encontrarTodoCoordinador() {
        return (List<coordinador>) coordinadorRepository.findAll();
    } 

    public List<planta> encontrarTodoPlanta() {
        return (List<planta>) plantaRepository.findAll();
    }

    public List<plantaEnLinea> encontrarTodoPlantaEnLinea() {
        return (List<plantaEnLinea>) plantaEnLineaRepository.findAll();
    }

    public List<cedulaNombreDto> encontrarCedulaYNombrePlantaEnLinea() {
        return plantaEnLineaRepository.findCedulaAndNombre();
    }

    public List<capacidadBackup> encontrarTodoUltimoMes() {
        // Obtener todos los registros
        List<capacidadBackup> todosLosRegistros = (List<capacidadBackup>) capacidadBackupRepository.findAllOrderByFechaReporteDesc();

        // Encontrar el último mes presente en los datos
        Optional<LocalDate> ultimaFecha = todosLosRegistros.stream()
            .map(capacidadBackup::getFechaReporte)
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

    public List<capacidadBackup> encontrarTodoContinuaEnPlanta(String role) {
        List<planta> todosLosRegistrosPlanta = (List<planta>) plantaRepository.findAll();
        List<capacidad> capacidades = (List<capacidad>) capacidadRepository.findAll();
        Map<String, capacidadBackup> capacidadPorCedula = new HashMap<String, capacidadBackup>();
        
        List<capacidadBackup> todasLasCapacidades = (List<capacidadBackup>) encontrarTodoUltimoMes();
        for (capacidadBackup capacidad : todasLasCapacidades) {
            capacidadPorCedula.put(capacidad.getCedula(), capacidad);
        }

        List<String> cedulasExistentes = new ArrayList<>();
        for (capacidad capacidad : capacidades) {
            cedulasExistentes.add(capacidad.getCedula());
        }

        List<capacidadBackup> registrosCoincidentes = new ArrayList<>();
        for (planta planta : todosLosRegistrosPlanta) {
            capacidadBackup capacidad = capacidadPorCedula.get(planta.getNit());
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

    public List<planta> encontrarPlantasSinCapacidad(String role) {
        List<planta> todosLosRegistrosPlanta = (List<planta>) plantaRepository.findAll();
        List<capacidad> capacidades = (List<capacidad>) capacidadRepository.findAll();

        List<String> cedulasExistentes = new ArrayList<>();
        for (capacidad capacidad : capacidades) {
            cedulasExistentes.add(capacidad.getCedula());
        }

        List<planta> plantasSinCapacidad = new ArrayList<>();
        for (planta planta : todosLosRegistrosPlanta) {
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

    private List<capacidadBackup> filtrarPorRolDirectorCapacidadesBackup(List<capacidadBackup> registros, String director) {
        // Filtrar registros por la columna 'director'
        return registros.stream()
                .filter(capacidad -> director.equals(capacidad.getDirector()))
                .collect(Collectors.toList());
    }

    private List<planta> filtrarPorRolDirectorPlanta(List<planta> plantas, String director) {
        // Implementa la lógica de filtrado basada en el rol del director aquí
        // Este es un método de ejemplo
        return plantas.stream()
                .filter(planta -> director.equals(planta.getDirector()))
                .collect(Collectors.toList());
    }

    public List<capacidadBackup> encontrarTodoNoContinuaEnPlanta() {
        List<planta> todosLosRegistrosPlanta = (List<planta>) plantaRepository.findAll();
        List<capacidadBackup> capacidadesNoCoincidentes = new ArrayList<>();
        Set<String> cedulasAgregadas = new HashSet<>();

        // Obtener todos los NITs de la planta
        Set<String> nitsPlanta = todosLosRegistrosPlanta.stream()
                                                        .map(planta::getNit)
                                                        .collect(Collectors.toSet());

        // Encontrar las capacidades que no tienen un NIT correspondiente en la planta
        for (capacidadBackup capacidad : capacidadBackupRepository.findAllOrderByFechaReporteDesc()) {
            String cedula = capacidad.getCedula();
            if (!nitsPlanta.contains(cedula) && !cedulasAgregadas.contains(cedula)) {
                capacidadesNoCoincidentes.add(capacidad);
                cedulasAgregadas.add(cedula);
            }
        }

        Collections.shuffle(capacidadesNoCoincidentes);

        return capacidadesNoCoincidentes;
    }

    public Map<String, Object> obtenerInformacionValidarPersonal (agregarPersonal personal) {
        System.err.println(personal);
        planta informacionPlanta = plantaRepository.findByNit(personal.getCedula());
        System.err.println(informacionPlanta);
        ciudad informacionCiudad = ciudadRepository.findByCiudad(informacionPlanta.getCiudad());
        System.err.println(informacionCiudad);
        coordinador informacionCoordinador = coordinadorRepository.findByCoordinador(personal.getCoordinador());
        System.err.println(informacionCoordinador);
        movil informacionMovil = movilRepository.findByTipoMovil(personal.getTipoMovil());
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

    public Map<String, Object> obtenerInformacionAgregarPersonal (agregarPersonal personal) {
        System.err.println(personal);
        planta informacionPlanta = plantaRepository.findByNit(personal.getCedula());
        System.err.println(informacionPlanta);
        ciudad informacionCiudad = ciudadRepository.findByCiudad(informacionPlanta.getCiudad());
        System.err.println(informacionCiudad);
        coordinador informacionCoordinador = coordinadorRepository.findByCoordinador(personal.getCoordinador());
        System.err.println(informacionCoordinador);
        movil informacionMovil = movilRepository.findByTipoMovil(personal.getTipoMovil());
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
