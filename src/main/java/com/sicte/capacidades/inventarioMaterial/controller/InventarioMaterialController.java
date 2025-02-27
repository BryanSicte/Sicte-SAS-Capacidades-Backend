package com.sicte.capacidades.inventarioMaterial.controller;

import com.sicte.capacidades.inventarioMaterial.entity.InventarioMaterial;
import com.sicte.capacidades.inventarioMaterial.service.InventarioMaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

@CrossOrigin(origins = { "https://sictepowergmail.github.io/", "https://BryanSicte.github.io", "https://bryanutria.github.io/",
        "http://localhost:3000" })
@RestController
@RequestMapping("/inventarioMaterial")
public class InventarioMaterialController {
    @Autowired
    private InventarioMaterialService inventarioMaterialService;

    @PostMapping("/cargarDatos")
    public ResponseEntity<InventarioMaterial> crearNuevoRegistro(
            @RequestBody InventarioMaterial nuevoRegistro) {
                InventarioMaterial registroGuardada = inventarioMaterialService.guardarRegistro(nuevoRegistro);
        return new ResponseEntity<>(registroGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/RegistrosInventarioMaterial")
    public ResponseEntity<List<InventarioMaterial>> getTodaRegistros() {
        List<InventarioMaterial> registros = inventarioMaterialService.encontrarTodoRegistros();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }
}
