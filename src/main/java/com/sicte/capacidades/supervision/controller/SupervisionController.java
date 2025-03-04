package com.sicte.capacidades.supervision.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sicte.capacidades.drive.GoogleDriveService;
import com.sicte.capacidades.supervision.dto.PlacaFechaDto;
import com.sicte.capacidades.supervision.entity.Registros;
import com.sicte.capacidades.supervision.service.SupervisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

import java.util.List;

@CrossOrigin(origins = {"https://sictepowergmail.github.io/","https://BryanSicte.github.io","http://localhost:3000","https://bryanutria.github.io/"})
@RestController
@RequestMapping("/supervision")
public class SupervisionController {
    @Autowired
    private SupervisionService supervisionService;

    private final String folderId = "1514Cz3GVufGhvpKo7pWiPXCPAzmJCC9p"; //carpeta supervision

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
    public ResponseEntity<byte[]> getImage(@RequestParam String imageName) {
        try {
            // Busca la imagen en Google Drive
            byte[] imageData = GoogleDriveService.getFileByName(imageName, folderId);

            if (imageData == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            // Determinar el tipo de contenido
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
        return "application/octet-stream"; // Default type for unknown files
    }
}