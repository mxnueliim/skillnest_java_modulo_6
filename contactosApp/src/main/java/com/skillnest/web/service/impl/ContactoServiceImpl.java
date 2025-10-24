package com.skillnest.web.service.impl;

import com.skillnest.web.model.Contacto;
import com.skillnest.web.service.ContactoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class ContactoServiceImpl implements ContactoService {

    private final List<Contacto> contactos = new CopyOnWriteArrayList<>();

    @Override
    public void registrar(Contacto contacto) {
        if (contacto != null) contactos.add(contacto);
    }

    @Override
    public List<Contacto> obtenerTodos() {
        return List.copyOf(contactos);
    }

    @Override
    public List<Contacto> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) return List.copyOf(contactos);
        final String q = nombre.toLowerCase();
        return contactos.stream()
                .filter(c -> c.getNombre() != null && c.getNombre().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
