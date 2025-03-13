package com.sicte.capacidades.chatbot.controller;

import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.chatbot.dto.ActualizarDatos;
import com.sicte.capacidades.chatbot.entity.Chatbot;
import com.sicte.capacidades.chatbot.service.ChatbotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = {"https://sictepowergmail.github.io/","https://BryanSicte.github.io","http://localhost:3000","https://bryanutria.github.io/"})
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
            String fechaHora = request.getFechaHora();
            String estadoFinal = request.getEstadoFinal();
            String observaciones = request.getObservaciones();

            recursosHumanosService.actualizarDatos(id, fechaHora, estadoFinal, observaciones);

            return ResponseEntity.ok("Datos actualizados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }
}