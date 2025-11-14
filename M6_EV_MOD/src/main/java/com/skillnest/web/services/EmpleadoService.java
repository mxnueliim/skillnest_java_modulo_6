package com.skillnest.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnest.web.models.Empleado;
import com.skillnest.web.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

	
}
