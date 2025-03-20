package com.sicte.capacidades.chatbot.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sicte.capacidades.chatbot.entity.Chatbot;

@Repository
public interface ChatbotRepository extends CrudRepository<Chatbot, String> {
    public Chatbot findByRegistro(String registro);
    public Chatbot findByStage(String stage);
    public Chatbot findByCelularChat(String celularChat);
    public Chatbot findByAceptoPolitica(String aceptoPolitica);
    public Chatbot findBynombreApellido(String nombreApellido);
    public Chatbot findByCelular(String celular);
    public Chatbot findByCiudad(String ciudad);
    public Chatbot findByCargo(String cargo);
    public Chatbot findByDetalleCargo(String detalleCargo);
    public Chatbot findByRespuestaFiltro1(String respuestaFiltro1);
    public Chatbot findByRespuestaFiltro2(String respuestaFiltro2);
    public Chatbot findByRespuestaFiltro3(String respuestaFiltro3);
    public Chatbot findByDireccion(String direccion);
    public Chatbot findByFechaHora(String fechaHora);
    public Chatbot findByEstadoFinal(String estadoFinal);
    public Chatbot findByObservaciones(String observaciones);

    @Modifying
    @Transactional
    @Query("UPDATE Chatbot s SET s.cargo = :cargo, s.fechaHora = :fechaHora, s.estadoFinal = :estadoFinal, s.observaciones = :observaciones WHERE s.id = :id")
    void actualizarDatos(@Param("id") Long id, @Param("cargo") String cargo, @Param("fechaHora") String fechaHora, @Param("estadoFinal") String estadoFinal, @Param("observaciones") String observaciones);
}
