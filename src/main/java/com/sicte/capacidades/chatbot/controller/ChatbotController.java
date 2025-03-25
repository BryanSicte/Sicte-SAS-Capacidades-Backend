package com.sicte.capacidades.chatbot.controller;

import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.chatbot.dto.ActualizarDatos;
import com.sicte.capacidades.chatbot.dto.RegistrarDatos;
import com.sicte.capacidades.chatbot.entity.Chatbot;
import com.sicte.capacidades.chatbot.service.ChatbotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = {"https://sictepowergmail.github.io/", "https://BryanSicte.github.io", "http://localhost:3000",
    "https://bryanutria.github.io/"})
@RestController
@RequestMapping("/recursosHumanos")
public class ChatbotController {

    @Autowired
    private ChatbotService recursosHumanosService;

    @GetMapping("/RegistrosChatbot")
    public ResponseEntity<List<Chatbot>> getTodaRegistrosChatbot() {
        List<Chatbot> registros = recursosHumanosService.encontrarTodoRegistrosChatbot();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @PostMapping("/actualizarDatosChatBot")
    public ResponseEntity<String> actualizarDatosChatBot(@RequestBody ActualizarDatos request) {
        try {
            Long id = request.getId();
            String cargo = request.getCargo();
            String fechaHora = request.getFechaHora();
            String estadoFinal = request.getEstadoFinal();
            String observaciones = request.getObservaciones();
            String asistencia = request.getAsistencia();
            String seleccion = request.getSeleccion();
            String examenesMedicos = request.getExamenesMedicos();
            String contratacion = request.getContratacion();
            String estadoContratacion = request.getEstadoContratacion();

            recursosHumanosService.actualizarDatos(id, cargo, fechaHora, estadoFinal, observaciones, asistencia,
                    seleccion, examenesMedicos, contratacion, estadoContratacion);

            return ResponseEntity.ok("Datos actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @PostMapping("/registrarDatosChatBot")
    public ResponseEntity<String> registrarDatosChatBot(@RequestBody RegistrarDatos request) {
        try {
            String registro = request.getRegistro();
            String fuente = request.getFuente();
            String stage = request.getStage();
            String nombreApellido = request.getNombreApellido();
            String celular = request.getCelular();
            String ciudad = request.getCiudad();
            String cargo = request.getCargo();
            String fechaHora = request.getFechaHora();
            String fechaHoraInicial = request.getFechaHoraInicial();
            String estadoFinal = request.getEstadoFinal();

            recursosHumanosService.registrarDatos(registro, fuente, stage, nombreApellido, celular,
                    ciudad, cargo, fechaHora, fechaHoraInicial, estadoFinal);

            return ResponseEntity.ok("Datos agregados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar los datos");
        }
    }
}
