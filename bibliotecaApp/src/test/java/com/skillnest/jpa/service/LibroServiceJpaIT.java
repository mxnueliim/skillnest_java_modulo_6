package com.skillnest.jpa.service;

import com.skillnest.jdbc.service.LibroServiceJdbc;
import com.skillnest.jdbc.model.Libro;
import com.skillnest.jpa.entity.Autor;
import com.skillnest.jpa.entity.LibroEntity;
import com.skillnest.jpa.repository.AutorRepository;
import com.skillnest.jpa.repository.LibroRepository;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas de integración:
 * - Verifica creación con JDBC (JdbcTemplate)
 * - Verifica creación con JPA
 * - Verifica ROLLBACK en operación transaccional con error
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LibroServiceJpaIT {

    @Autowired
    private LibroServiceJdbc jdbcService;     // módulo JDBC Template

    @Autowired
    private LibroServiceJpa jpaService;       // módulo JPA

    @Autowired
    private AutorRepository autorRepo;

    @Autowired
    private LibroRepository libroRepo;

    @BeforeEach
    void limpiarBD() {
        // Orden importa (FK libros -> autores)
        libroRepo.deleteAll();
        autorRepo.deleteAll();
    }

    @Test
    @Order(1)
    void jdbc_creaYLista() {
        Long id = jdbcService.crearLibro("El túnel", 1948);
        assertNotNull(id);

        List<Libro> todos = jdbcService.listarTodos();
        assertEquals(1, todos.size());
        assertEquals("El túnel", todos.get(0).getTitulo());
        assertEquals(1948, todos.get(0).getAnioPublicacion());
    }

    @Test
    @Order(2)
    void jpa_creaAutorYLibro_commit() {
        Autor autor = jpaService.guardarAutor("Isabel Allende");
        assertNotNull(autor.getId());

        LibroEntity le = jpaService.guardarLibroConAutor(autor.getId(), "La casa de los espíritus", 1982);
        assertNotNull(le.getId());
        assertNotNull(le.getAutor());
        assertEquals("Isabel Allende", le.getAutor().getNombre());

        List<LibroEntity> conAutor = jpaService.listarLibrosConAutor();
        assertEquals(1, conAutor.size());
        assertEquals("La casa de los espíritus", conAutor.get(0).getTitulo());
        assertEquals(1982, conAutor.get(0).getAnioPublicacion());
        assertEquals("Isabel Allende", conAutor.get(0).getAutor().getNombre());
    }

    @Test
    @Order(3)
    void jpa_errorForzado_rollback() {
        // Ejecuta transacción que crea autor y luego falla ANTES de guardar el libro.
        assertThrows(RuntimeException.class, () ->
                jpaService.crearAutorYLibro_conErrorForzado("Autor X", "Libro X", 2000)
        );

        // Debe ROLLBACK: no hay autor ni libro persistidos
        assertEquals(0, autorRepo.count());
        assertEquals(0, libroRepo.count());
    }

    @Test
    @Order(4)
    void jpa_checkedException_rollbackFor() {
        // Forzamos Exception "checked" (anio < 0) -> rollback por rollbackFor=Exception
        assertThrows(Exception.class, () ->
                jpaService.crearAutorYLibro_rollbackFor("Autor Y", "Libro Y", -1)
        );

        assertEquals(0, autorRepo.count());
        assertEquals(0, libroRepo.count());
    }
}
