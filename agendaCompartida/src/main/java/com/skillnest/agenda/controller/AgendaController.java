package com.skillnest.agenda.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skillnest.agenda.model.Evento;
import com.skillnest.agenda.service.AgendaService;

@Controller
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    // Home: redirige al listado
    @GetMapping("/")
    public String home() {
        return "redirect:/eventos";
    }

    // Mostrar formulario (GET)
    @GetMapping({"/eventos/nuevo", "/eventos/form"})
    public String mostrarFormulario(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/form";
    }

    // Guardar (POST)
    @PostMapping("/eventos/guardar")
    public String guardarEvento(@ModelAttribute Evento evento, Model model) {
        agendaService.agregar(evento);
        model.addAttribute("mensaje", "Evento agregado correctamente");
        model.addAttribute("evento", new Evento()); // limpiar el form
        return "eventos/form";
    }

    // Listar (GET) con alias
    @GetMapping({"/eventos", "/eventos/listar"})
    public String listarEventos(@RequestParam(required = false) String fecha, Model model) {
        List<Evento> eventos;
        if (fecha != null && !fecha.isEmpty()) {
            eventos = agendaService.buscarPorFecha(LocalDate.parse(fecha));
            model.addAttribute("filtro", fecha);
        } else {
            eventos = agendaService.listar();
        }
        model.addAttribute("eventos", eventos);
        return "eventos/lista";
    }
}
