package com.skillnest.agenda.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillnest.agenda.model.Evento;

@Service
public class AgendaServiceImpl implements AgendaService {

    // Simula una base de datos en memoria
    private final List<Evento> eventos = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void agregar(Evento evento) {
        eventos.add(evento);
    }

    @Override
    public List<Evento> listar() {
        // copia para evitar modificaciones externas
        synchronized (eventos) {
            return new ArrayList<>(eventos);
        }
    }

    @Override
    public List<Evento> buscarPorFecha(LocalDate fecha) {
        List<Evento> resultado = new ArrayList<>();
        synchronized (eventos) {
            for (Evento e : eventos) {
                if (e.getFecha() != null && e.getFecha().equals(fecha)) {
                    resultado.add(e);
                }
            }
        }
        return resultado;
    }
}
