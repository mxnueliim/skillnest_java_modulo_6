package com.skillnest.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String mostrarInicio() {
        return "inicio"; // Renderiza WEB-INF/views/inicio.jsp.
    }
}
