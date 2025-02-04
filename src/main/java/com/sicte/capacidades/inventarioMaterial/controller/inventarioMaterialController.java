package com.sicte.capacidades.inventarioMaterial.controller;

import com.sicte.capacidades.inventarioMaterial.entity.inventarioMaterial;
import com.sicte.capacidades.inventarioMaterial.service.inventarioMaterialService;
import com.sicte.capacidades.solicitudMaterial.dto.actualizarEstadoCantidadRestantePorDespachoRequest;
import com.sicte.capacidades.solicitudMaterial.dto.actualizarEstadoDirectorRequest;
import com.sicte.capacidades.solicitudMaterial.dto.rutaPDFRequest;
import com.sicte.capacidades.solicitudMaterial.dto.namePDFSave;
import com.sicte.capacidades.solicitudMaterial.entity.registrosSolicitudMaterial;
import com.sicte.capacidades.solicitudMaterial.entity.registrosSolicitudMaterialEntregado;
import com.sicte.capacidades.solicitudMaterial.entity.relacionPersonal;
import com.sicte.capacidades.solicitudMaterial.service.solicitudMaterialService;

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
        "http://localhost:3000" })
@RestController
@RequestMapping("/inventarioMaterial")
public class inventarioMaterialController {
    @Autowired
    private inventarioMaterialService inventarioMaterialService;

    @PostMapping("/cargarDatos")
    public ResponseEntity<inventarioMaterial> crearNuevoRegistro(
            @RequestBody inventarioMaterial nuevoRegistro) {
                inventarioMaterial registroGuardada = inventarioMaterialService.guardarRegistro(nuevoRegistro);
        return new ResponseEntity<>(registroGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/RegistrosInventarioMaterial")
    public ResponseEntity<List<inventarioMaterial>> getTodaRegistros() {
        List<inventarioMaterial> registros = inventarioMaterialService.encontrarTodoRegistros();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }
}
