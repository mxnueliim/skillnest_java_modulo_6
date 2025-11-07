package com.skillnest.jpa.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "libros")
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=200)
    private String titulo;

    @Column(name="anio_publicacion", nullable=false)
    private Integer anioPublicacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", foreignKey = @ForeignKey(name = "fk_libros_autor"))
    private Autor autor; // puede ser null (libros creados por JDBC sin autor)

    public LibroEntity() {}
    public LibroEntity(String titulo, Integer anioPublicacion, Autor autor) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Integer getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(Integer anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibroEntity)) return false;
        return Objects.equals(id, ((LibroEntity)o).id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}
