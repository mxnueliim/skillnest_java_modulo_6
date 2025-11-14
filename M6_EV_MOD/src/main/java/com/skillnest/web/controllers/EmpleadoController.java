package com.skillnest.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skillnest.web.models.Empleado;
import com.skillnest.web.services.EmpleadoService;

@Controller
public class EmpleadoController {
	
	 @Autowired
	 private EmpleadoService empleadoService;
	 
    @GetMapping("/empleados")
    public String mostrarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("empleados", empleados);
        return "empleados/lista-empleados";
    }

}
