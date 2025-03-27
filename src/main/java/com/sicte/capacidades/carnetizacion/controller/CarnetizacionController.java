package com.sicte.capacidades.carnetizacion.controller;

import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.carnetizacion.entity.Carnetizacion;
import com.sicte.capacidades.carnetizacion.service.CarnetizacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = { "https://sictepowergmail.github.io/", "https://BryanSicte.github.io", "http://localhost:3000",
        "https://bryanutria.github.io/" })
@RestController
@RequestMapping("/carnetizacion")
public class CarnetizacionController {

    @Autowired
    private CarnetizacionService carnetizacionService;

    @GetMapping("/Registros")
    public ResponseEntity<List<Carnetizacion>> getTodaRegistros() {
        List<Carnetizacion> registros = carnetizacionService.encontrarTodoRegistros();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @PostMapping("/crearRegistro")
    public ResponseEntity<Carnetizacion> crearNuevoRegistro(
            @RequestBody Carnetizacion nuevoRegistro) {
        Carnetizacion registroGuardado = carnetizacionService.guardarRegistro(nuevoRegistro);
        return new ResponseEntity<>(registroGuardado, HttpStatus.CREATED);
    }
}