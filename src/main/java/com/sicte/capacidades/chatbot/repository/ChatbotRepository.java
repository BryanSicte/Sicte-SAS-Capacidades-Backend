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

    public Chatbot findByFechaHoraInicial(String fechaHoraInicial);

    public Chatbot findByAsistencia(String asistencia);

    public Chatbot findBySeleccion(String seleccion);

    public Chatbot findByExamenesMedicos(String examenesMedicos);

    public Chatbot findByContratacion(String contratacion);

    public Chatbot findByEstadoContratacion(String estadoContratacion);

    @Modifying
    @Transactional
    @Query("UPDATE Chatbot s SET s.cargo = :cargo, s.fechaHora = :fechaHora, s.estadoFinal = :estadoFinal, s.observaciones = :observaciones, s.asistencia = :asistencia, s.seleccion = :seleccion, s.examenesMedicos = :examenesMedicos, s.contratacion = :contratacion, s.estadoContratacion = :estadoContratacion WHERE s.id = :id")
    void actualizarDatos(@Param("id") Long id, @Param("cargo") String cargo, @Param("fechaHora") String fechaHora,
            @Param("estadoFinal") String estadoFinal, @Param("observaciones") String observaciones,
            @Param("asistencia") String asistencia, @Param("seleccion") String seleccion,
            @Param("examenesMedicos") String examenesMedicos, @Param("contratacion") String contratacion,
            @Param("estadoContratacion") String estadoContratacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO registros_chatbot (registro, fuente, stage, nombreApellido, celular, ciudad, cargo, fechaHora, fechaHoraInicial, estadoFinal) " +
               "VALUES (:registro, :fuente, :stage, :nombreApellido, :celular, :ciudad, :cargo, :fechaHora, :fechaHoraInicial, :estadoFinal)", nativeQuery = true)
    void registrarDatos(@Param("registro") String registro, @Param("fuente") String fuente,
            @Param("stage") String stage, @Param("nombreApellido") String nombreApellido,
            @Param("celular") String celular, @Param("ciudad") String ciudad,
            @Param("cargo") String cargo, @Param("fechaHora") String fechaHora,
            @Param("fechaHoraInicial") String fechaHoraInicial, @Param("estadoFinal") String estadoFinal);
}
