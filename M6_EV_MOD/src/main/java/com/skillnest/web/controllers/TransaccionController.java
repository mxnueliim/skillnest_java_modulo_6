package com.skillnest.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skillnest.web.services.TransferenciaService;

@Controller
public class TransaccionController {
	@Autowired
	public TransferenciaService transferenciaService;
	
	@RequestMapping("/transaccion")
	public String transaccion() {
		transferenciaService.transferirDinero(1l, 2l, 1500);
		
		return "";
	}

}
