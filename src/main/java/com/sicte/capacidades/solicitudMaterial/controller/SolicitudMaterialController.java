package com.sicte.capacidades.solicitudMaterial.controller;

import com.sicte.capacidades.solicitudMaterial.dto.ActualizarEstadoCantidadRestantePorDespachoRequest;
import com.sicte.capacidades.solicitudMaterial.dto.ActualizarEstadoDirectorRequest;
import com.sicte.capacidades.solicitudMaterial.dto.NamePDFSave;
import com.sicte.capacidades.solicitudMaterial.dto.RutaPDFRequest;
import com.sicte.capacidades.solicitudMaterial.entity.RegistrosSolicitudMaterial;
import com.sicte.capacidades.solicitudMaterial.entity.RegistrosSolicitudMaterialEntregado;
import com.sicte.capacidades.solicitudMaterial.entity.RelacionPersonal;
import com.sicte.capacidades.solicitudMaterial.service.SolicitudMaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = { "https://sictepowergmail.github.io/", "https://BryanSicte.github.io",
        "https://bryanutria.github.io/",
        "http://localhost:3000" })
@RestController
@RequestMapping("/solicitudMaterial")
public class SolicitudMaterialController {
    @Autowired
    private SolicitudMaterialService solicitudMaterialService;

    private static final String LOCAL_UPLOAD_COMPRIMIDOS = "C:/Users/Juan/Nextcloud/APP Material/COMPRIMIDOS/";
    private static final String LOCAL_UPLOAD_KMZ = "C:/Users/Juan/Nextcloud/APP Material/KMZ/";
    private static final String LOCAL_UPLOAD_PDF = "C:/Users/Juan/Nextcloud/APP Material/PDF/";
    private static final String LOCAL_UPLOAD_PDF_2 = "C:\\Users\\Juan\\Nextcloud\\APP Material\\PDF\\";

    @PostMapping("/cargarKmz")
    public ResponseEntity<String> cargarKmz(@RequestParam("file") MultipartFile file,
            @RequestParam("filename") String filename) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado ningún archivo");
        }

        try {
            String newFileName = filename.endsWith(".kmz") ? filename : filename + ".kmz";
            File destinationFile = new File(LOCAL_UPLOAD_KMZ + newFileName);
            destinationFile.getParentFile().mkdirs();
            file.transferTo(destinationFile);

            return ResponseEntity.ok("Archivo subido con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    @PostMapping("/cargarDiseño")
    public ResponseEntity<String> cargarDiseños(@RequestParam("file") MultipartFile file,
            @RequestParam("filename") String filename) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado ningún archivo");
        }

        try {
            String newFileName;
            if (filename.endsWith(".zip") || filename.endsWith(".rar") || filename.endsWith(".7z")) {
                newFileName = filename;
            } else {
                newFileName = filename + ".zip";
            }
            File destinationFile = new File(LOCAL_UPLOAD_COMPRIMIDOS + newFileName);
            destinationFile.getParentFile().mkdirs();
            file.transferTo(destinationFile);

            return ResponseEntity.ok("Archivo subido con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    @PostMapping("/cargarPDF")
    public ResponseEntity<String> cargarPDF(@RequestParam("file") MultipartFile file,
            @RequestParam("filename") String filename) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado ningún archivo");
        }

        try {
            String newFileName;
            if (filename.endsWith(".pdf")) {
                newFileName = filename;
            } else {
                newFileName = filename + ".pdf";
            }
            File destinationFile = new File(LOCAL_UPLOAD_PDF + newFileName);
            destinationFile.getParentFile().mkdirs();
            file.transferTo(destinationFile);

            return ResponseEntity.ok("Archivo subido con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    @PostMapping("/cargarDatos")
    public ResponseEntity<RegistrosSolicitudMaterial> crearNuevoRegistro(
            @RequestBody RegistrosSolicitudMaterial nuevoRegistro) {
        RegistrosSolicitudMaterial registroGuardada = solicitudMaterialService.guardarRegistro(nuevoRegistro);
        return new ResponseEntity<>(registroGuardada, HttpStatus.CREATED);
    }

    @PostMapping("/cargarDatosEntregados")
    public ResponseEntity<RegistrosSolicitudMaterialEntregado> crearNuevoRegistroEntregado(
            @RequestBody RegistrosSolicitudMaterialEntregado nuevoRegistro) {
        System.err.println(nuevoRegistro);
        RegistrosSolicitudMaterialEntregado registroGuardada = solicitudMaterialService
                .guardarRegistroEntregado(nuevoRegistro);
        return new ResponseEntity<>(registroGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/RegistrosSolicitudMaterial")
    public ResponseEntity<List<RegistrosSolicitudMaterial>> getTodaRegistros() {
        List<RegistrosSolicitudMaterial> registros = solicitudMaterialService.encontrarTodoRegistros();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/RegistrosEntregadosSolicitudMaterial")
    public ResponseEntity<List<RegistrosSolicitudMaterialEntregado>> getTodaRegistrosEntregados() {
        List<RegistrosSolicitudMaterialEntregado> registros = solicitudMaterialService
                .encontrarTodoRegistrosEntregado();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/ObtenerKmz")
    public ResponseEntity<Resource> getKmz(@RequestParam String fileName) {
        try {
            File file = new File(Paths.get(LOCAL_UPLOAD_KMZ, fileName).toUri());
            if (!file.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            String contentType = getContentTypeKmz(fileName);

            UrlResource resource = new UrlResource(file.toURI());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private String getContentTypeKmz(String fileName) {
        if (fileName.endsWith(".kmz")) {
            return "mapa/kmz";
        }
        return "application/octet-stream";
    }

    @GetMapping("/ObtenerDiseño")
    public ResponseEntity<Resource> getDiseño(@RequestParam String fileName) {
        try {
            File file = new File(Paths.get(LOCAL_UPLOAD_COMPRIMIDOS, fileName).toUri());
            if (!file.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            String contentType = getContentTypeDiseño(fileName);

            UrlResource resource = new UrlResource(file.toURI());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private String getContentTypeDiseño(String fileName) {
        if (fileName.endsWith(".zip")) {
            return "disenos/zip";
        } else if (fileName.endsWith(".rar")) {
            return "disenos/rar";
        } else if (fileName.endsWith(".7z")) {
            return "disenos/7z";
        }
        return "application/octet-stream";
    }

    @GetMapping("/ObtenerPDF")
    public ResponseEntity<Resource> getPDF(@RequestParam String fileName) {
        try {
            File file = new File(Paths.get(LOCAL_UPLOAD_PDF, fileName).toUri());
            if (!file.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            String contentType = getContentTypePdf(fileName);

            UrlResource resource = new UrlResource(file.toURI());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private String getContentTypePdf(String fileName) {
        if (fileName.endsWith(".pdf")) {
            return "application/pdf";
        }

        return "application/octet-stream";
    }

    @PostMapping("/actualizarEstadoAnalista")
    public ResponseEntity<String> actualizarEstadorAnalista(@RequestBody ActualizarEstadoDirectorRequest request) {
        try {
            List<Long> ids = request.getIds();
            String estado = request.getEstado();
            String observaciones = request.getObservacionesTemporal();
            String fecha = request.getFechaRegistro();

            for (Long id : ids) {
                solicitudMaterialService.actualizarEstadoAnalista(id, estado, observaciones, fecha);
                if (estado == "Rechazado") {
                    solicitudMaterialService.actualizarEstadoDirector(id, estado, observaciones, fecha);
                    solicitudMaterialService.actualizarEstadoDireccionOperacion(id, estado, null, fecha);
                    solicitudMaterialService.actualizarEstadoEntregaBodega(id, estado, null);
                }
            }

            return ResponseEntity.ok("Estado y observaciones actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @PostMapping("/actualizarEstadoDirector")
    public ResponseEntity<String> actualizarEstadoDirector(@RequestBody ActualizarEstadoDirectorRequest request) {
        try {
            List<Long> ids = request.getIds();
            String estado = request.getEstado();
            String observaciones = request.getObservacionesTemporal();
            String fecha = request.getFechaRegistro();

            for (Long id : ids) {
                solicitudMaterialService.actualizarEstadoDirector(id, estado, observaciones, fecha);
                if (estado == "Rechazado") {
                    solicitudMaterialService.actualizarEstadoDireccionOperacion(id, estado, null, fecha);
                    solicitudMaterialService.actualizarEstadoEntregaBodega(id, estado, null);
                }
            }

            return ResponseEntity.ok("Estado y observaciones actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @PostMapping("/actualizarEstadoDireccionOperacion")
    public ResponseEntity<String> actualizarEstadoDireccionOperacion(
            @RequestBody ActualizarEstadoDirectorRequest request) {
        try {
            List<Long> ids = request.getIds();
            String estado = request.getEstado();
            String observaciones = request.getObservacionesTemporal();
            String fecha = request.getFechaRegistro();

            for (Long id : ids) {
                solicitudMaterialService.actualizarEstadoDireccionOperacion(id, estado, observaciones, fecha);
                if (estado == "Rechazado") {
                    solicitudMaterialService.actualizarEstadoEntregaBodega(id, estado, null);
                }
            }

            return ResponseEntity.ok("Estado y observaciones actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @PostMapping("/actualizarEstadoEntregaBodega")
    public ResponseEntity<String> actualizarEstadoEntregaBodega(
            @RequestBody ActualizarEstadoDirectorRequest request) {
        try {
            List<Long> ids = request.getIds();
            String estado = request.getEstado();
            String observaciones = request.getObservacionesTemporal();

            for (Long id : ids) {
                solicitudMaterialService.actualizarEstadoEntregaBodega(id, estado, observaciones);
            }

            return ResponseEntity.ok("Estado y observaciones actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @PostMapping("/actualizarEstadoCantidadRestantePorDespacho")
    public ResponseEntity<String> actualizarEstadoCantidadRestantePorDespacho(
            @RequestBody ActualizarEstadoCantidadRestantePorDespachoRequest request) {
        try {
            List<Long> ids = request.getIds();
            List<String> cantidades = request.getCantidades();

            if (ids.size() != cantidades.size()) {
                throw new IllegalArgumentException("La cantidad de IDs no coincide con la cantidad de cantidades.");
            }

            for (int i = 0; i < ids.size(); i++) {
                Long id = ids.get(i);
                String cantidad = cantidades.get(i);

                solicitudMaterialService.actualizarEstadoCantidadRestantePorDespacho(id, cantidad);
            }

            return ResponseEntity.ok("Estado y observaciones actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @PostMapping("/actualizarEstadoCantidadDisponibleMaterial")
    public ResponseEntity<String> actualizarEstadoCantidadDisponibleMaterial(
            @RequestBody ActualizarEstadoCantidadRestantePorDespachoRequest request) {
        try {
            List<Long> ids = request.getIds();
            List<String> cantidades = request.getCantidades();

            if (ids.size() != cantidades.size()) {
                throw new IllegalArgumentException("La cantidad de IDs no coincide con la cantidad de cantidades.");
            }

            for (int i = 0; i < ids.size(); i++) {
                Long id = ids.get(i);
                String cantidad = cantidades.get(i);

                solicitudMaterialService.actualizarEstadoCantidaDisponibleMaterial(id, cantidad);
            }

            return ResponseEntity.ok("Estado y observaciones actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @PostMapping("/actualizarEstadoEntregaBodegaPDFs")
    public ResponseEntity<String> actualizarEstadoEstregaBodegaPDFs(@RequestBody NamePDFSave request) {
        try {
            List<Long> ids = request.getIds();
            String namePdfs = request.getPdfNombre();

            for (Long id : ids) {
                solicitudMaterialService.actualizarEstadoEntregaBodegaPDFs(id, namePdfs);
            }

            return ResponseEntity.ok("Estado y observaciones actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @PostMapping("/leerPDF")
    public String procesarPdf(@RequestBody RutaPDFRequest rutaPDFRequest) {
        String pythonScriptPath = "C:\\Users\\Juan\\Documents\\Desarrollos\\Leer PDFs\\Leer PDF.py";
        String rutaPdf = LOCAL_UPLOAD_PDF_2 + rutaPDFRequest.getRutaPdf();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath, rutaPdf);
            Process process = processBuilder.start();

            // Captura la salida del script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            process.waitFor();
            reader.close();

            return output.toString();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "{\"error\": \"Error al procesar el PDF\"}";
        }
    }

    @GetMapping("/RelacionPersonal")
    public ResponseEntity<List<RelacionPersonal>> getTodaRelacionPersonal() {
        List<RelacionPersonal> registros = solicitudMaterialService.encontrarTodoRelacionPersonal();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @PostMapping("/actualizarEstadoCierreProyecto")
    public ResponseEntity<String> actualizarEstadoCierreProyecto(@RequestBody NamePDFSave request) {
        try {
            List<Long> ids = request.getIds();
            String estadoProyecto = request.getPdfNombre();

            System.err.println(ids);
            System.err.println(estadoProyecto);

            for (Long id : ids) {
                solicitudMaterialService.actualizarEstadoCierreProyecto(id, estadoProyecto);
            }

            return ResponseEntity.ok("Estado actualizado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }
}
