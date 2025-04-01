package com.sicte.capacidades.carnetizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sicte.capacidades.carnetizacion.entity.Carnetizacion;
import com.sicte.capacidades.carnetizacion.service.CarnetizacionService;
import com.sicte.capacidades.drive.GoogleDriveService;

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

    @GetMapping("/ObtenerImagen")
    public ResponseEntity<byte[]> getImage(@RequestParam String imageName) {
        try {
            // Busca la imagen en Google Drive
            byte[] imageData = GoogleDriveService.getFileByName(imageName, folderId);

            if (imageData == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            String contentType = getContentType(imageName);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType)
                    .body(imageData);
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
        return "application/octet-stream";
    }
}