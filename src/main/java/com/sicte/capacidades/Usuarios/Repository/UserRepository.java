package com.sicte.capacidades.usuarios.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sicte.capacidades.usuarios.entity.user;

@Repository
public interface userRepository extends CrudRepository<user, String> {
    public user findByNombre(String nombre);

    public user findByCorreo(String correo);

    public user findByCedula(String cedula);

    public user findByRol(String rol);

    public user findByTelefono(String telefono);

    public user findByContrasena(String contrasena);

    @Modifying
    @Transactional
    @Query("UPDATE user s SET s.contrasena = :contrasena WHERE s.correo = :email")
    void actualizarContrasena(@Param("email") String email, @Param("contrasena") String contrasena);

}
