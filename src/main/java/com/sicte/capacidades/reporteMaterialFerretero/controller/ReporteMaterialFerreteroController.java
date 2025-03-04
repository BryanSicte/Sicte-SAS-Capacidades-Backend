package com.sicte.capacidades.reporteMaterialFerretero.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sicte.capacidades.drive.GoogleDriveService;
import com.sicte.capacidades.reporteMaterialFerretero.entity.ReporteMaterial;
import com.sicte.capacidades.reporteMaterialFerretero.service.ReporteMaterialFerreteroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = { "https://sictepowergmail.github.io/", "https://BryanSicte.github.io", "https://bryanutria.github.io/",
        "http://localhost:3000" })
@RestController
@RequestMapping("/reporteMaterialFerretero")
public class ReporteMaterialFerreteroController {
    @Autowired
    private ReporteMaterialFerreteroService reporteMaterialFerreteroService;

    private final String folderId = "1TxvRKPfW7i9BHGGyxGf5Rdr_dnP2pqsT"; //carpeta Ferretero


    @PostMapping("/cargarDatosReporteMaterialFerretero")
    public ResponseEntity<ReporteMaterial> crearReporteMaterialFerretero(@RequestBody ReporteMaterial nuevoRegistro) {
            ReporteMaterial registroGuardada = reporteMaterialFerreteroService.guardarReporteMaterialFerretero(nuevoRegistro);
        return new ResponseEntity<>(registroGuardada, HttpStatus.CREATED);
    }

    @PostMapping("/cargarDatosReporteMaterialFerreteroFirma")
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

    @GetMapping("/obtenerReporteMaterialFerretero")
    public ResponseEntity<List<ReporteMaterial>> obtenerReporteMaterialFerretero() {
        List<ReporteMaterial> registros = reporteMaterialFerreteroService.encontrarTodoReporteMaterialFerretero();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/obtenerReporteMaterialFerreteroFirma")
    public ResponseEntity<byte[]> getImage(@RequestParam String imageName) {
        try {
            byte[] imageData = GoogleDriveService.getFileByName(imageName, folderId);

            if (imageData == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            String contentType = getContentType(imageName);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType) // Ajusta el tipo de contenido según el formato de la imagen
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
