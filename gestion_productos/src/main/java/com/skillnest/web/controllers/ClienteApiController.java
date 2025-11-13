package com.skillnest.web.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.skillnest.web.models.Producto;

@Controller
public class ClienteApiController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cliente/productos")
    public String consumirProductos() {

        // 1) LOGIN: obtener token
        String loginUrl = "http://localhost:8080/auth/login";

        Map<String, String> credenciales = Map.of(
            "usuario", "admin",
            "password", "1234"
        );

        ResponseEntity<Map> loginResponse =
                restTemplate.postForEntity(loginUrl, credenciales, Map.class);

        String token = (String) loginResponse.getBody().get("token");
        System.out.println("TOKEN OBTENIDO: " + token);

        // 2) CONSUMIR ENDPOINT PROTEGIDO
        String productosUrl = "http://localhost:8080/api/productos/listar";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<Producto[]> productosResponse =
                restTemplate.exchange(productosUrl, HttpMethod.GET, entity, Producto[].class);

        List<Producto> productos = Arrays.asList(productosResponse.getBody());

        // 3) Mostrar en consola (para que el profe vea que se consumió la API)
        productos.forEach(p ->
                System.out.println("Producto: " + p.getNombre() + " - Precio: " + p.getPrecio())
        );

        // 4) Si quieres mostrar en JSP, puedes guardar la lista en el modelo
        // model.addAttribute("productos", productos);
        // return "clienteProductos";

        return "redirect:/"; // por ahora solo redirigimos o puedes devolver una vista si prefieres
    }
}
