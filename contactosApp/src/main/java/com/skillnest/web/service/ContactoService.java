package com.skillnest.web.service;

import java.util.List;

import com.skillnest.web.model.Contacto;

public interface ContactoService {
    void registrar(Contacto contacto);
    List<Contacto> obtenerTodos();
    List<Contacto> buscarPorNombre(String nombre);
}