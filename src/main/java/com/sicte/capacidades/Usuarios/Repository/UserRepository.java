package com.sicte.capacidades.usuarios.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sicte.capacidades.usuarios.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    public User findByNombre(String nombre);

    public User findByCorreo(String correo);

    public User findByCedula(String cedula);

    public User findByRol(String rol);

    public User findByTelefono(String telefono);

    public User findByContrasena(String contrasena);

    @Modifying
    @Transactional
    @Query("UPDATE User s SET s.contrasena = :contrasena WHERE s.correo = :email")
    void ActualizarContrasena(@Param("email") String email, @Param("contrasena") String contrasena);

}
