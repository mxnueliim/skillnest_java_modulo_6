package com.skillnest.jpa.service;

import com.skillnest.jpa.entity.Autor;
import com.skillnest.jpa.entity.LibroEntity;
import com.skillnest.jpa.repository.AutorRepository;
import com.skillnest.jpa.repository.LibroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroServiceJpa {

    private final AutorRepository autorRepo;
    private final LibroRepository libroRepo;

    public LibroServiceJpa(AutorRepository autorRepo, LibroRepository libroRepo) {
        this.autorRepo = autorRepo;
        this.libroRepo = libroRepo;
    }

    /* ===== Autores ===== */

    @Transactional
    public Autor guardarAutor(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del autor es obligatorio.");
        }
        return autorRepo.findByNombre(nombre.trim())
                .orElseGet(() -> autorRepo.save(new Autor(nombre.trim())));
    }

    @Transactional
    public Autor actualizarNombreAutor(Long autorId, String nuevoNombre) {
        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            throw new IllegalArgumentException("El nuevo nombre no puede ser vacío.");
        }
        Autor a = autorRepo.findById(autorId)
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado: " + autorId));
        a.setNombre(nuevoNombre.trim());
        return autorRepo.save(a);
    }

    /* ===== Libros ===== */

    @Transactional
    public LibroEntity guardarLibroConAutor(Long autorId, String titulo, Integer anioPublicacion) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título del libro es obligatorio.");
        }
        if (anioPublicacion == null) {
            throw new IllegalArgumentException("El año de publicación es obligatorio.");
        }
        Autor autor = autorRepo.findById(autorId)
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado: " + autorId));
        return libroRepo.save(new LibroEntity(titulo.trim(), anioPublicacion, autor));
    }

    @Transactional(readOnly = true)
    public List<LibroEntity> listarLibrosConAutor() {
        return libroRepo.findAll();
    }

    @Transactional
    public void eliminarLibro(Long libroId) {
        if (libroRepo.existsById(libroId)) {
            libroRepo.deleteById(libroId);
        }
    }
    
    /**
     * Crea un autor (si no existe por nombre) y luego crea un libro asociado.
     * Todo en UNA transacción. Si algo falla, se hace ROLLBACK.
     */
    @Transactional
    public LibroEntity crearAutorYLibro(String nombreAutor, String tituloLibro, Integer anioPublicacion) {
        // Validaciones simples (como te enseñaron: regla de negocio en la capa de servicio)
        if (nombreAutor == null || nombreAutor.isBlank()) {
            throw new IllegalArgumentException("El nombre del autor es obligatorio.");
        }
        if (tituloLibro == null || tituloLibro.isBlank()) {
            throw new IllegalArgumentException("El título del libro es obligatorio.");
        }
        if (anioPublicacion == null) {
            throw new IllegalArgumentException("El año de publicación es obligatorio.");
        }

        // 1) Crear/obtener autor (misma transacción)
        Autor autor = autorRepo.findByNombre(nombreAutor.trim())
                .orElseGet(() -> autorRepo.save(new Autor(nombreAutor.trim())));

        // 2) Crear libro asociado (misma transacción)
        LibroEntity libro = new LibroEntity(tituloLibro.trim(), anioPublicacion, autor);
        return libroRepo.save(libro);
    }

    /**
     * Igual que el anterior, pero forzamos un error a mitad para demostrar el rollback.
     * -> Útil para la prueba del Paso 5.
     */
    @Transactional
    public void crearAutorYLibro_conErrorForzado(String nombreAutor, String tituloLibro, Integer anioPublicacion) {
        if (nombreAutor == null || nombreAutor.isBlank()) {
            throw new IllegalArgumentException("El nombre del autor es obligatorio.");
        }

        // 1) Crear/obtener autor
        Autor autor = autorRepo.findByNombre(nombreAutor.trim())
                .orElseGet(() -> autorRepo.save(new Autor(nombreAutor.trim())));

        // 2) Forzar un fallo ANTES de persistir el libro
        throw new RuntimeException("Fallo forzado para comprobar ROLLBACK");

        // 3) (Nunca llega aquí) Crear libro
        // libroRepo.save(new LibroEntity(tituloLibro.trim(), anioPublicacion, autor));
    }

    /**
     * Variante con rollback explícito para cualquier Exception (checked o no).
     */
    @Transactional(rollbackFor = Exception.class)
    public void crearAutorYLibro_rollbackFor(String nombreAutor, String tituloLibro, Integer anioPublicacion) throws Exception {
        Autor autor = autorRepo.findByNombre(nombreAutor.trim())
                .orElseGet(() -> autorRepo.save(new Autor(nombreAutor.trim())));

        // Simular un problema "checked" (por ejemplo, validación externa)
        if (anioPublicacion != null && anioPublicacion < 0) {
            throw new Exception("Año inválido (ejemplo de Exception checked).");
        }

        libroRepo.save(new LibroEntity(tituloLibro.trim(), anioPublicacion, autor));
    }
}
