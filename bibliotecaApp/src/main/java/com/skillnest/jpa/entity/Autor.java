package com.skillnest.jpa.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String nombre;

    public Autor() {}
    public Autor(String nombre) { this.nombre = nombre; }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor a = (Autor) o;
        return Objects.equals(id, a.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}
