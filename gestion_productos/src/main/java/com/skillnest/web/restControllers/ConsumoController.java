package com.skillnest.web.restControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillnest.web.models.Producto;

@RestController
public class ConsumoController {

   /* @GetMapping("/consumir")
    public Producto obtenerProducto() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.ejemplo.com/producto/1";
        Producto producto = restTemplate.getForObject(url, Producto.class);
        return producto;
    }
    */
}