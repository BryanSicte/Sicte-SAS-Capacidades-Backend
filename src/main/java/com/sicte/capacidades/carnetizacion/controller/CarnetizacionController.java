package com.sicte.capacidades.carnetizacion.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sicte.capacidades.drive.GoogleDriveService;
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

    private final String folderId = "1jMD6UqxKbVqY003qb9xo9kND5gjkcmU5"; //carpeta carnetizacion

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

    @PostMapping("/cargarImagen")
    public ResponseEntity<String> cargarImagen(@RequestParam("file") MultipartFile file, @RequestParam("filename") String filename) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado ningún archivo");
        }

        try {
            String fileId = GoogleDriveService.uploadFile(file, filename, folderId);

            return ResponseEntity.ok("Archivo subido con éxito. ID: " + fileId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }
}