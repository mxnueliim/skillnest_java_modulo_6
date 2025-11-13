package com.skillnest.web.restControllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillnest.web.Component.MiServicio;


@RestController
public class HolaController {
	private static final Logger log = LoggerFactory.getLogger(HolaController.class);
	//inyeccion de dependencias
	@Autowired
	MiServicio servicio;

	//http://localhost:8080/mensaje
    @GetMapping("/mensaje")
    public String mensaje() {
    	log.info("Accediendo al endpoint /mensaje para probar el logger");
        return servicio.obtenerMensaje();
    }

}
