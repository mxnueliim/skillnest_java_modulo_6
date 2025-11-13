package com.skillnest.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skillnest.web.models.Persona;
import com.skillnest.web.services.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	@Autowired
	PersonaService personaService;
	
	//metodos
	
    @GetMapping
    public String listarPersonas(Model model) {
    	List<Persona> personas = personaService.listarTodas();
    	model.addAttribute("personas", personas);
        //model.addAttribute("personas", personaService.listarTodas());
        return "personas/listado";
    }
	
    @GetMapping("/crear")
    public String mostrarFormulario() {
        return "personas/crear";
    }

    @PostMapping("/guardar")
    public String guardarPersona(@RequestParam String nombre, @RequestParam String email, Model model) {
        
    	//intancia de la clase
    	Persona persona = new Persona();
    	//llenar los atributos
    	persona.setNombre(nombre);
    	persona.setEmail(email);
    	
    	//pasamos el objeto
    	Persona persona_retorno = personaService.registrarPersona(persona);
    	
    	model.addAttribute("id", persona_retorno.getId());
    	model.addAttribute("nombre", persona_retorno.getNombre());
        model.addAttribute("email", persona_retorno.getEmail());
        return "personas/detalles";
    }
}
