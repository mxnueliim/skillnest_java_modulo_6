package com.skillnest.agenda.service;

import java.time.LocalDate;
import java.util.List;

import com.skillnest.agenda.model.Evento;

public interface AgendaService {
    void agregar(Evento evento);
    List<Evento> listar();
    List<Evento> buscarPorFecha(LocalDate fecha);
}
