package com.sicte.capacidades.capacidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.capacidad.dto.CedulaNombreDto;
import com.sicte.capacidades.capacidad.entity.AgregarPersonal;
import com.sicte.capacidades.capacidad.entity.Capacidad;
import com.sicte.capacidades.capacidad.entity.CapacidadBackup;
import com.sicte.capacidades.capacidad.entity.Coordinador;
import com.sicte.capacidades.capacidad.entity.Movil;
import com.sicte.capacidades.capacidad.entity.Planta;
import com.sicte.capacidades.capacidad.entity.PlantaEnLinea;
import com.sicte.capacidades.capacidad.repository.CapacidadRepository.RoleRequest;
import com.sicte.capacidades.capacidad.service.CapacidadService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"https://sictepowergmail.github.io/","https://BryanSicte.github.io","http://localhost:3000", "https://bryanutria.github.io/"})
@RestController
@RequestMapping("/capacidad")
public class CapacidadController {
    @Autowired
    private CapacidadService capacidadService;

    @GetMapping("/TodoBackup")
    public ResponseEntity<List<CapacidadBackup>> getTodaCapacidadBackup() {
        List<CapacidadBackup> capacidades = capacidadService.encontrarTodoCapacidadBackup();
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/Todo")
    public ResponseEntity<List<Capacidad>> getTodaCapacidad(@RequestBody RoleRequest roleRequest) {
        List<Capacidad> capacidades = capacidadService.encontrarTodoCapacidad(roleRequest.getRole());
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @GetMapping("/Movil")
    public ResponseEntity<List<Movil>> getTodaMovil() {
        List<Movil> movil = capacidadService.encontrarTodoMovil();
        return new ResponseEntity<>(movil, HttpStatus.OK);
    }

    @GetMapping("/Planta")
    public ResponseEntity<List<Planta>> getTodaPlanta() {
        List<Planta> planta = capacidadService.encontrarTodoPlanta();
        return new ResponseEntity<>(planta, HttpStatus.OK);
    }

    @GetMapping("/PlantaEnLinea")
    public ResponseEntity<List<PlantaEnLinea>> getTodaPlantaEnLinea() {
        List<PlantaEnLinea> plantaEnLinea = capacidadService.encontrarTodoPlantaEnLinea();
        return new ResponseEntity<>(plantaEnLinea, HttpStatus.OK);
    }

    @GetMapping("/PlantaEnLineaCedulaNombre")
    public ResponseEntity<List<CedulaNombreDto>> getCedulaNombrePlantaEnLinea() {
        List<CedulaNombreDto> plantaEnLinea = capacidadService.encontrarCedulaYNombrePlantaEnLinea();
        return new ResponseEntity<>(plantaEnLinea, HttpStatus.OK);
    }

    @GetMapping("/Coordinador")
    public ResponseEntity<List<Coordinador>> getTodoCoordinador() {
        List<Coordinador> coordinador = capacidadService.encontrarTodoCoordinador();
        return new ResponseEntity<>(coordinador, HttpStatus.OK);
    }

    @GetMapping("/UltimoMesBackup")
    public ResponseEntity<List<CapacidadBackup>> getTodaCapacidadUltimoMes() {
        List<CapacidadBackup> capacidades = capacidadService.encontrarTodoUltimoMes();
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/ContinuaEnPlanta")
    public ResponseEntity<List<CapacidadBackup>> getTodaCapacidadContinuaEnPlanta(@RequestBody RoleRequest roleRequest) {
        List<CapacidadBackup> capacidades = capacidadService.encontrarTodoContinuaEnPlanta(roleRequest.getRole());
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/ContinuaEnPlantaSinCapacidad")
    public ResponseEntity<List<Planta>> getEncontrarPlantasSinCapacidad(@RequestBody RoleRequest roleRequest) {
        List<Planta> plantas = capacidadService.encontrarPlantasSinCapacidad(roleRequest.getRole());
        return new ResponseEntity<>(plantas, HttpStatus.OK);
    }

    @GetMapping("/NoContinuaEnPlanta")
    public ResponseEntity<List<CapacidadBackup>> getTodaCapacidadNoContinuaEnPlanta() {
        List<CapacidadBackup> capacidades = capacidadService.encontrarTodoNoContinuaEnPlanta();
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/AgregarCapacidad")
    public ResponseEntity<Capacidad> crearNuevaCapacidad(@RequestBody Capacidad nuevaCapacidad) {
        String fechaReporte = capacidadService.obtenerFechaReporte();
        nuevaCapacidad.setFechaReporte(fechaReporte);

        Capacidad capacidadGuardada = capacidadService.guardarCapacidad(nuevaCapacidad);
        return new ResponseEntity<>(capacidadGuardada, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar-filas")
    public ResponseEntity<String> eliminarFilas(@RequestBody Map<String, String> requestBody) {
        String cedula = requestBody.get("cedula");
        try {
            capacidadService.eliminarFilasPorCedula(cedula);
            return new ResponseEntity<>("Filas eliminadas correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar filas: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/agregarPersonal")
    public ResponseEntity<?> agregarPersonal(@RequestBody AgregarPersonal agregarPersonal) {
        Map<String, Object> response = capacidadService.obtenerInformacionAgregarPersonal(agregarPersonal);
        Capacidad nuevaCapacidad = new Capacidad();
        
        nuevaCapacidad.setCedula((String) response.get("cedula"));
        nuevaCapacidad.setNombreCompleto((String) response.get("nombre"));
        nuevaCapacidad.setCargo((String) response.get("cargo"));
        nuevaCapacidad.setCentroCosto((String) response.get("centroCosto"));
        nuevaCapacidad.setNomina((String) response.get("nomina"));
        nuevaCapacidad.setRegional((String) response.get("regional"));
        nuevaCapacidad.setCiudadTrabajo((String) response.get("ciudad"));
        nuevaCapacidad.setRed((String) response.get("red"));
        nuevaCapacidad.setCliente((String) response.get("cliente"));
        nuevaCapacidad.setArea((String) response.get("area"));
        nuevaCapacidad.setSubArea(response.get("subarea") != null && !((String) response.get("subarea")).isEmpty() ? (String) response.get("subarea") : "null");
        nuevaCapacidad.setTipoDeMovil((String) response.get("tipoMovil"));
        nuevaCapacidad.setTipoFacturacion((String) response.get("tipoFacturacion"));
        nuevaCapacidad.setMovil((String) response.get("movil"));
        nuevaCapacidad.setCoordinador((String) response.get("coordinador"));
        nuevaCapacidad.setDirector((String) response.get("director"));
        nuevaCapacidad.setValorEsperado((String) response.get("valorEsperado"));
        nuevaCapacidad.setPlaca(response.get("placa") != null && !((String) response.get("placa")).isEmpty() ? (String) response.get("placa") : "null");
        nuevaCapacidad.setFechaReporte((String) response.get("fechaReporte"));
        nuevaCapacidad.setMes(response.get("mes").toString());
        nuevaCapacidad.setAño(response.get("año").toString());
        nuevaCapacidad.setTurnos((String) response.get("turnos"));
        nuevaCapacidad.setPersonas((String) response.get("personas"));
        nuevaCapacidad.setCarpeta(response.get("carpeta") != null && !((String) response.get("carpeta")).isEmpty() ? (String) response.get("carpeta") : "null");

        Capacidad capacidadGuardada = capacidadService.guardarCapacidad(nuevaCapacidad);
        System.err.println(capacidadGuardada);
        return new ResponseEntity<>(capacidadGuardada, HttpStatus.CREATED);
    }

    @PostMapping("/agregarPersonalValidarPersonal")
    public ResponseEntity<?> agregarPersonalValidarPersonal(@RequestBody AgregarPersonal agregarPersonal) {
        Map<String, Object> response = capacidadService.obtenerInformacionValidarPersonal(agregarPersonal);
        Capacidad nuevaCapacidad = new Capacidad();

        nuevaCapacidad.setCedula((String) response.get("cedula"));
        nuevaCapacidad.setNombreCompleto((String) response.get("nombre"));
        nuevaCapacidad.setCargo((String) response.get("cargo"));
        nuevaCapacidad.setCentroCosto((String) response.get("centroCosto"));
        nuevaCapacidad.setNomina((String) response.get("nomina"));
        nuevaCapacidad.setRegional((String) response.get("regional"));
        nuevaCapacidad.setCiudadTrabajo((String) response.get("ciudad"));
        nuevaCapacidad.setRed((String) response.get("red"));
        nuevaCapacidad.setCliente((String) response.get("cliente"));
        nuevaCapacidad.setArea((String) response.get("area"));
        nuevaCapacidad.setSubArea(response.get("subarea") != null && !((String) response.get("subarea")).isEmpty() ? (String) response.get("subarea") : "null");
        nuevaCapacidad.setTipoDeMovil((String) response.get("tipoMovil"));
        nuevaCapacidad.setTipoFacturacion((String) response.get("tipoFacturacion"));
        nuevaCapacidad.setMovil((String) response.get("movil"));
        nuevaCapacidad.setCoordinador((String) response.get("coordinador"));
        nuevaCapacidad.setDirector((String) response.get("director"));
        nuevaCapacidad.setValorEsperado((String) response.get("valorEsperado"));
        nuevaCapacidad.setPlaca(response.get("placa") != null && !((String) response.get("placa")).isEmpty() ? (String) response.get("placa") : "null");
        nuevaCapacidad.setFechaReporte((String) response.get("fechaReporte"));
        nuevaCapacidad.setMes(response.get("mes").toString());
        nuevaCapacidad.setAño(response.get("año").toString());
        nuevaCapacidad.setTurnos((String) response.get("turnos"));
        nuevaCapacidad.setPersonas((String) response.get("personas"));
        nuevaCapacidad.setCarpeta(response.get("carpeta") != null && !((String) response.get("carpeta")).isEmpty() ? (String) response.get("carpeta") : "null");


        Capacidad capacidadGuardada = capacidadService.guardarCapacidad(nuevaCapacidad);
        System.err.println(capacidadGuardada);
        return new ResponseEntity<>(capacidadGuardada, HttpStatus.CREATED);
    }
    
}