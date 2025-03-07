package com.sicte.capacidades.chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.chatbot.entity.Chatbot;
import com.sicte.capacidades.chatbot.repository.ChatbotRepository;

@Service
public class RecursosHumanosService{
    @Autowired
    ChatbotRepository chatbotRepository;

    public List<Chatbot> encontrarTodoRegistrosChatbot() {
        return (List<Chatbot>) chatbotRepository.findAll();
    }
}
