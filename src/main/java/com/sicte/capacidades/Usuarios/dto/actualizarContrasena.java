package com.sicte.capacidades.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ActualizarContrasena {
    private String emailToken;
    private String password2;

    // Getters y setters
    public String getEmail() {
        return emailToken;
    }

    public void setEmail(String email) {
        this.emailToken = email;
    }

    public String getContrasena() {
        return password2;
    }

    public void setContrasena(String contrasena) {
        this.password2 = contrasena;
    }
}
