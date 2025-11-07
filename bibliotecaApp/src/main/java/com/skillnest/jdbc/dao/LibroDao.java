package com.skillnest.jdbc.dao;

import com.skillnest.jdbc.model.Libro;

import java.util.List;

public interface LibroDao {
    Long insert(Libro libro);                 // retorna ID generado
    List<Libro> findAll();
    List<Libro> findByAnio(int anioPublicacion);
    int updateTitulo(Long id, String nuevoTitulo); // filas afectadas
    int deleteById(Long id);                      // filas afectadas
}
