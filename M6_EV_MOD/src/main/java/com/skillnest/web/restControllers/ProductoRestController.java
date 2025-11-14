package com.skillnest.web.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillnest.web.models.Producto;
import com.skillnest.web.services.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")   // versionado
@CrossOrigin(origins = "*")           // CORS
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;

    // GET /api/v1/productos
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = productoService.listarTodos();
        return ResponseEntity.ok(productos);                 // 200
    }

    // GET /api/v1/productos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable long id) {
        Producto producto = productoService.obtener(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();        // 404 si no existe
        }
        return ResponseEntity.ok(producto);                  // 200
    }

    // POST /api/v1/productos
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
    	producto.setId(null);
    	
        Producto creado = productoService.crear(producto);
        return ResponseEntity.status(HttpStatus.CREATED)     // 201
                             .body(creado);
    }

    // PUT /api/v1/productos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable long id,
                                               @RequestBody Producto producto) {
        Producto actualizado = productoService.actualizar(id, producto);
        return ResponseEntity.ok(actualizado);               // 200
    }

    // DELETE /api/v1/productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();           // 204
    }
}
