package com.sicte.capacidades.Usuarios.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @NotNull(message = "El campo no puede ser nulo")
    private String nombre;
    @Email
    private String correo;
    @NotNull(message = "El campo no puede ser nulo")
    private String cedula;
    @NotNull(message = "El campo no puede ser nulo")
    private String rol;
    @NotNull(message = "El campo no puede ser nulo")
    private String telefono;
    @NotNull(message = "El campo no puede ser nulo")
    private String contrasena;
}