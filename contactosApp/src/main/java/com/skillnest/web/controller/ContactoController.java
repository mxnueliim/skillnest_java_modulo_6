package com.skillnest.web.controller;

import com.skillnest.web.model.Contacto;
import com.skillnest.web.service.ContactoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @PostConstruct
    public void init() {
        System.out.println("========================================");
        System.out.println("✅ CONTROLADOR INICIALIZADO CORRECTAMENTE");
        System.out.println("========================================");
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        System.out.println(">>> Accediendo a /contacto/form");
        model.addAttribute("contacto", new Contacto());
        return "contacto/form";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("contacto") @Valid Contacto contacto,
                            BindingResult result,
                            Model model) {
        if (result.hasErrors()) {
            // vuelve al formulario con mensajes de error
            return "contacto/form";
        }
        contactoService.registrar(contacto);
        return "redirect:/contacto/lista";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        System.out.println(">>> Accediendo a /contacto/lista");
        model.addAttribute("contactos", contactoService.obtenerTodos());
        return "contacto/lista";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam(required = false) String nombre, Model model) {
        System.out.println(">>> Buscando contacto: " + nombre);
        model.addAttribute("contactos", contactoService.buscarPorNombre(nombre));
        model.addAttribute("q", nombre);
        return "contacto/lista";
    }
}