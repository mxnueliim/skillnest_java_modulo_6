package com.skillnest.agenda.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class Evento {
    private String titulo;
    private LocalDate fecha;
    private String descripcion;
    private String responsable;

    public Evento() {}

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}
