package com.skillnest.web.services;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public boolean esNombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty() && nombre.length() >= 3;
    }

    public boolean esEmailValido(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }
}
