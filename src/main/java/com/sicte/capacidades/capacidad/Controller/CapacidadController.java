package com.sicte.capacidades.capacidad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.capacidad.Entity.AgregarPersonal;
import com.sicte.capacidades.capacidad.Entity.Capacidad;
import com.sicte.capacidades.capacidad.Entity.CapacidadBackup;
import com.sicte.capacidades.capacidad.Entity.Movil;
import com.sicte.capacidades.capacidad.Entity.Planta;
import com.sicte.capacidades.capacidad.Repository.CapacidadRepository.RoleRequest;
import com.sicte.capacidades.capacidad.Service.CapacidadService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://bryanutria.github.io")
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

    @GetMapping("/Todo")
    public ResponseEntity<List<Capacidad>> getTodaCapacidad() {
        List<Capacidad> capacidades = capacidadService.encontrarTodoCapacidad();
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @GetMapping("/Movil")
    public ResponseEntity<List<Movil>> getTodaMovil() {
        List<Movil> movil = capacidadService.encontrarTodoMovil();
        return new ResponseEntity<>(movil, HttpStatus.OK);
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
        nuevaCapacidad.setSubArea((String) response.get("subarea"));
        nuevaCapacidad.setTipoDeMovil((String) response.get("tipoMovil"));
        nuevaCapacidad.setTipoFacturacion((String) response.get("tipoFacturacion"));
        nuevaCapacidad.setMovil((String) response.get("movil"));
        nuevaCapacidad.setCoordinador((String) response.get("coordinador"));
        nuevaCapacidad.setDirector((String) response.get("director"));
        nuevaCapacidad.setValorEsperado((String) response.get("valorEsperado"));
        nuevaCapacidad.setPlaca((String) response.get("placa"));
        nuevaCapacidad.setFechaReporte((String) response.get("fechaReporte"));
        nuevaCapacidad.setMes(response.get("mes").toString());
        nuevaCapacidad.setAño(response.get("año").toString());
        nuevaCapacidad.setTurnos((String) response.get("turnos"));
        nuevaCapacidad.setPersonas((String) response.get("personas"));

        Capacidad capacidadGuardada = capacidadService.guardarCapacidad(nuevaCapacidad);
        System.err.println(capacidadGuardada);
        return new ResponseEntity<>(capacidadGuardada, HttpStatus.CREATED);
    }

    
}