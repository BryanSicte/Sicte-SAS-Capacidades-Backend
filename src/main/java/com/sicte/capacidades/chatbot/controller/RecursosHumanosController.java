package com.sicte.capacidades.chatbot.controller;

import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.chatbot.entity.Chatbot;
import com.sicte.capacidades.chatbot.service.RecursosHumanosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = {"https://sictepowergmail.github.io/","https://BryanSicte.github.io","http://localhost:3000","https://bryanutria.github.io/"})
@RestController
@RequestMapping("/recursosHumanos")
public class RecursosHumanosController {

    @Autowired
    private RecursosHumanosService recursosHumanosService;

    @GetMapping("/RegistrosChatbot")
    public ResponseEntity<List<Chatbot>> getTodaRegistrosChatbot() {
        List<Chatbot> registros = recursosHumanosService.encontrarTodoRegistrosChatbot();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }
}