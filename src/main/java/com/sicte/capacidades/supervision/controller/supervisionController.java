package com.sicte.capacidades.supervision.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sicte.capacidades.supervision.dto.PlacaFechaDto;
import com.sicte.capacidades.supervision.entity.Registros;
import com.sicte.capacidades.supervision.service.SupervisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = {"https://sictepowergmail.github.io/","https://BryanSicte.github.io","http://localhost:3000","https://bryanutria.github.io/"})
@RestController
@RequestMapping("/supervision")
public class SupervisionController {
    @Autowired
    private SupervisionService supervisionService;

    private static final String LOCAL_UPLOAD_DIR = "C:/Users/Juan/Nextcloud/APP Supervision/";

    @PostMapping("/cargarImagen")
    public ResponseEntity<String> cargarImagen(@RequestParam("file") MultipartFile file, @RequestParam("filename") String filename) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado ningún archivo");
        }

        try {
            String newFileName = filename;
            // Guarda el archivo en el servidor con el nuevo nombre
            File destinationFile = new File(LOCAL_UPLOAD_DIR + newFileName);
            destinationFile.getParentFile().mkdirs(); // Crea directorios si no existen
            file.transferTo(destinationFile);

            return ResponseEntity.ok("Archivo subido con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    @PostMapping("/cargarDatos")
    public ResponseEntity<Registros> crearNuevoRegistro(@RequestBody Registros nuevoRegistro) {
        Registros registroGuardada = supervisionService.guardarRegistro(nuevoRegistro);
        return new ResponseEntity<>(registroGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/RegistrosSupervision")
    public ResponseEntity<List<Registros>> getTodaRegistros() {
        List<Registros> registros = supervisionService.encontrarTodoRegistros();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/RegistrosSupervisionFechaPlaca")
    public ResponseEntity<List<PlacaFechaDto>> getRegistrosFechaPlaca() {
        List<PlacaFechaDto> registros = supervisionService.encontrarFechaYPlacaRegistros();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/ObtenerImagen")
    public ResponseEntity<Resource> getImage(@RequestParam String imageName) {
        try {
            File file = new File(Paths.get(LOCAL_UPLOAD_DIR, imageName).toUri());
            if (!file.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            String contentType = getContentType(imageName);

            UrlResource resource = new UrlResource(file.toURI());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType) // Ajusta el tipo de contenido según el formato de la imagen
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private String getContentType(String fileName) {
        if (fileName.endsWith(".png")) {
            return "image/png";
        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            return "image/jpeg";
        }
        return "application/octet-stream"; // Default type for unknown files
    }
}