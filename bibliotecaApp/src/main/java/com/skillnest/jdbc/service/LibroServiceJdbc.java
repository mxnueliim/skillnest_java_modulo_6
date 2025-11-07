package com.skillnest.jdbc.service;

import com.skillnest.jdbc.dao.LibroDao;
import com.skillnest.jdbc.model.Libro;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroServiceJdbc {

    private final LibroDao dao;

    public LibroServiceJdbc(LibroDao dao) {
        this.dao = dao;
    }

    @Transactional
    public Long crearLibro(String titulo, Integer anioPublicacion) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        if (anioPublicacion == null) {
            throw new IllegalArgumentException("El año de publicación es obligatorio");
        }
        return dao.insert(new Libro(titulo, anioPublicacion));
    }

    public List<Libro> listarTodos() {
        return dao.findAll();
    }

    public List<Libro> buscarPorAnio(int anio) {
        return dao.findByAnio(anio);
    }

    @Transactional
    public boolean actualizarTitulo(Long id, String nuevoTitulo) {
        if (nuevoTitulo == null || nuevoTitulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede ser vacío");
        }
        return dao.updateTitulo(id, nuevoTitulo) > 0;
    }

    @Transactional
    public boolean eliminar(Long id) {
        return dao.deleteById(id) > 0;
    }
}
