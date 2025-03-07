package com.sicte.capacidades.chatbot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicte.capacidades.chatbot.entity.Chatbot;

@Repository
public interface ChatbotRepository extends CrudRepository<Chatbot, String> {
    public Chatbot findByregistro (String registro);
    public Chatbot findBystage (String stage);
    public Chatbot findBynombreApellido (String nombreApellido);
    public Chatbot findBycelular (String celular);
    public Chatbot findByciudad (String ciudad);
    public Chatbot findBycargo (String cargo);
    public Chatbot findBydetalleCargo (String detalleCargo);
    public Chatbot findByrespuestaFiltro1 (String respuestaFiltro1);
    public Chatbot findByrespuestaFiltro2 (String respuestaFiltro2);
    public Chatbot findByrespuestaFiltro3 (String respuestaFiltro3);
    public Chatbot findBydireccion (String direccion);
    public Chatbot findByfechaHora (String fechaHora);
    public Chatbot findByestadoFinal (String estadoFinal);
    public Chatbot findByobservaciones (String observaciones);
}
