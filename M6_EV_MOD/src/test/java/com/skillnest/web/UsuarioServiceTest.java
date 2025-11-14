package com.skillnest.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillnest.web.services.UsuarioService;

@SpringBootTest
class UsuarioServiceTest {

	@Autowired
    private UsuarioService usuarioService;

    @Test
    public void testNombreValido() {
        assertTrue(usuarioService.esNombreValido("Ana"));
        assertFalse(usuarioService.esNombreValido(""));
        assertFalse(usuarioService.esNombreValido("  "));
        assertFalse(usuarioService.esNombreValido("Jo"));
    }

    @Test
    public void testEmailValido() {
        assertTrue(usuarioService.esEmailValido("usuario@example.com"));
        assertFalse(usuarioService.esEmailValido("usuario.com"));
        assertFalse(usuarioService.esEmailValido(null));
    }

    @Test
    public void testMayorDeEdad() {
        assertTrue(usuarioService.esMayorDeEdad(20));
        assertFalse(usuarioService.esMayorDeEdad(17));
    }

}
