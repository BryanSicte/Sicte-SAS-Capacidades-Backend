package com.sicte.capacidades.usuarios.dto;

import java.util.Date;
import java.util.UUID;

public class tokenUtils {
    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public static Date calculateExpiryDate(int minutes) {
        return new Date(System.currentTimeMillis() + minutes * 60 * 1000);
    }
}
