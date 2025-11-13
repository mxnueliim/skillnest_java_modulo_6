package com.skillnest.web.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillnest.web.models.Estudiante;
import com.skillnest.web.services.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listar() {
        return estudianteService.listarTodos();
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return estudianteService.guardar(estudiante);
    }

    @GetMapping("/{id}")
    //  http://localhost:8080/api/estudiantes/1
    public Estudiante obtener(@PathVariable Long id) {
        return estudianteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        Estudiante existente = estudianteService.buscarPorId(id);
        if (existente != null) {
            existente.setNombre(estudiante.getNombre());
            existente.setCarrera(estudiante.getCarrera());
            existente.setEmail(estudiante.getEmail());
            return estudianteService.guardar(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
    }
}