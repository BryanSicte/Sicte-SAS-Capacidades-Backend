package com.sicte.capacidades.capacidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.capacidad.dto.cedulaNombreDto;
import com.sicte.capacidades.capacidad.entity.agregarPersonal;
import com.sicte.capacidades.capacidad.entity.capacidad;
import com.sicte.capacidades.capacidad.entity.capacidadBackup;
import com.sicte.capacidades.capacidad.entity.coordinador;
import com.sicte.capacidades.capacidad.entity.movil;
import com.sicte.capacidades.capacidad.entity.planta;
import com.sicte.capacidades.capacidad.entity.plantaEnLinea;
import com.sicte.capacidades.capacidad.repository.capacidadRepository.RoleRequest;
import com.sicte.capacidades.capacidad.service.capacidadService;

import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;

@CrossOrigin(origins = {"https://sictepowergmail.github.io/","https://BryanSicte.github.io","http://localhost:3000"})
@RestController
@RequestMapping("/capacidad")
public class capacidadController {
    @Autowired
    private capacidadService capacidadService;

    @GetMapping("/TodoBackup")
    public ResponseEntity<List<capacidadBackup>> getTodaCapacidadBackup() {
        List<capacidadBackup> capacidades = capacidadService.encontrarTodoCapacidadBackup();
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/Todo")
    public ResponseEntity<List<capacidad>> getTodaCapacidad(@RequestBody RoleRequest roleRequest) {
        List<capacidad> capacidades = capacidadService.encontrarTodoCapacidad(roleRequest.getRole());
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @GetMapping("/Movil")
    public ResponseEntity<List<movil>> getTodaMovil() {
        List<movil> movil = capacidadService.encontrarTodoMovil();
        return new ResponseEntity<>(movil, HttpStatus.OK);
    }

    @GetMapping("/Planta")
    public ResponseEntity<List<planta>> getTodaPlanta() {
        List<planta> planta = capacidadService.encontrarTodoPlanta();
        return new ResponseEntity<>(planta, HttpStatus.OK);
    }

    @GetMapping("/PlantaEnLinea")
    public ResponseEntity<List<plantaEnLinea>> getTodaPlantaEnLinea() {
        List<plantaEnLinea> plantaEnLinea = capacidadService.encontrarTodoPlantaEnLinea();
        return new ResponseEntity<>(plantaEnLinea, HttpStatus.OK);
    }

    @GetMapping("/PlantaEnLineaCedulaNombre")
    public ResponseEntity<List<cedulaNombreDto>> getCedulaNombrePlantaEnLinea() {
        List<cedulaNombreDto> plantaEnLinea = capacidadService.encontrarCedulaYNombrePlantaEnLinea();
        return new ResponseEntity<>(plantaEnLinea, HttpStatus.OK);
    }

    @GetMapping("/Coordinador")
    public ResponseEntity<List<coordinador>> getTodoCoordinador() {
        List<coordinador> coordinador = capacidadService.encontrarTodoCoordinador();
        return new ResponseEntity<>(coordinador, HttpStatus.OK);
    }

    @GetMapping("/UltimoMesBackup")
    public ResponseEntity<List<capacidadBackup>> getTodaCapacidadUltimoMes() {
        List<capacidadBackup> capacidades = capacidadService.encontrarTodoUltimoMes();
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/ContinuaEnPlanta")
    public ResponseEntity<List<capacidadBackup>> getTodaCapacidadContinuaEnPlanta(@RequestBody RoleRequest roleRequest) {
        List<capacidadBackup> capacidades = capacidadService.encontrarTodoContinuaEnPlanta(roleRequest.getRole());
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/ContinuaEnPlantaSinCapacidad")
    public ResponseEntity<List<planta>> getEncontrarPlantasSinCapacidad(@RequestBody RoleRequest roleRequest) {
        List<planta> plantas = capacidadService.encontrarPlantasSinCapacidad(roleRequest.getRole());
        return new ResponseEntity<>(plantas, HttpStatus.OK);
    }

    @GetMapping("/NoContinuaEnPlanta")
    public ResponseEntity<List<capacidadBackup>> getTodaCapacidadNoContinuaEnPlanta() {
        List<capacidadBackup> capacidades = capacidadService.encontrarTodoNoContinuaEnPlanta();
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/AgregarCapacidad")
    public ResponseEntity<capacidad> crearNuevaCapacidad(@RequestBody capacidad nuevaCapacidad) {
        String fechaReporte = capacidadService.obtenerFechaReporte();
        nuevaCapacidad.setFechaReporte(fechaReporte);

        capacidad capacidadGuardada = capacidadService.guardarCapacidad(nuevaCapacidad);
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
    public ResponseEntity<?> agregarPersonal(@RequestBody agregarPersonal agregarPersonal) {
        Map<String, Object> response = capacidadService.obtenerInformacionAgregarPersonal(agregarPersonal);
        capacidad nuevaCapacidad = new capacidad();
        
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

        capacidad capacidadGuardada = capacidadService.guardarCapacidad(nuevaCapacidad);
        System.err.println(capacidadGuardada);
        return new ResponseEntity<>(capacidadGuardada, HttpStatus.CREATED);
    }

    @PostMapping("/agregarPersonalValidarPersonal")
    public ResponseEntity<?> agregarPersonalValidarPersonal(@RequestBody agregarPersonal agregarPersonal) {
        Map<String, Object> response = capacidadService.obtenerInformacionValidarPersonal(agregarPersonal);
        capacidad nuevaCapacidad = new capacidad();

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


        capacidad capacidadGuardada = capacidadService.guardarCapacidad(nuevaCapacidad);
        System.err.println(capacidadGuardada);
        return new ResponseEntity<>(capacidadGuardada, HttpStatus.CREATED);
    }
    
}