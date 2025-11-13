package com.skillnest.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillnest.web.services.CalculadoraService;

@SpringBootTest
public class CalculadoraServiceTest {

    @Autowired
    private CalculadoraService calculadoraService;

    @Test
    public void testSuma() {
        int resultado = calculadoraService.sumar(2, 3);
        assertEquals(5, resultado);
    }
}