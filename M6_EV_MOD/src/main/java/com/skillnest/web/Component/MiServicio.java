package com.skillnest.web.Component;

import org.springframework.stereotype.Component;

@Component
public class MiServicio {
    public String obtenerMensaje() {
        return "Mensaje desde el servicio.";
    }
}
