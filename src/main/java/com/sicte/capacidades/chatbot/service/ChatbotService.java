package com.sicte.capacidades.chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.chatbot.entity.Chatbot;
import com.sicte.capacidades.chatbot.repository.ChatbotRepository;

@Service
public class ChatbotService {
    @Autowired
    ChatbotRepository chatbotRepository;

    public List<Chatbot> encontrarTodoRegistrosChatbot() {
        return (List<Chatbot>) chatbotRepository.findAll();
    }

    public void actualizarDatos(Long id, String cargo, String fechaHora, String estadoFinal, String observaciones,
            String asistencia, String seleccion, String examenesMedicos, String contratacion,
            String estadoContratacion) {
        chatbotRepository.actualizarDatos(id, cargo, fechaHora, estadoFinal, observaciones, asistencia, seleccion,
                examenesMedicos, contratacion, estadoContratacion);
    }
}
