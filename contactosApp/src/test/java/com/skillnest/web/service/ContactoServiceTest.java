package com.skillnest.web.service;

import com.skillnest.web.model.Contacto;
import com.skillnest.web.service.impl.ContactoServiceImpl;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ContactoServiceTest {

    @Test
    void registrarYListarContactos() {
        ContactoService service = new ContactoServiceImpl();

        assertTrue(service.obtenerTodos().isEmpty());

        service.registrar(new Contacto("Ana", "ana@mail.com", "111"));
        service.registrar(new Contacto("Benjamín", "benja@mail.com", "222"));

        List<Contacto> todos = service.obtenerTodos();
        assertEquals(2, todos.size());
        assertEquals("Ana", todos.get(0).getNombre());

        // buscarPorNombre (case-insensitive, contiene)
        assertEquals(1, service.buscarPorNombre("ana").size());
        assertEquals(0, service.buscarPorNombre("xyz").size());
    }
}
