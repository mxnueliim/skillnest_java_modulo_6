package com.skillnest.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnest.web.models.Estudiante;
import com.skillnest.web.repositories.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante buscarPorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}
