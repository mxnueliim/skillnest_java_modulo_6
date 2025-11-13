package com.skillnest.web.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;
	
	@GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.listarTodos();
    }
	
    @GetMapping("/{id}")//ok; pendiente manejo de errores
    public Producto obtener(@PathVariable long id) {
        return productoService.obtener(id);
    }

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public Producto crear(@RequestBody Producto producto) {
        return productoService.crear(producto);
    }
    
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable long id,@RequestBody Producto producto) {
    	return productoService.actualizar(id,producto);
    }
    
    
    @DeleteMapping("/{id}")//ok; pendiente manejo de errores
    public Producto eliminar(@PathVariable long id) {
        return productoService.eliminar(id);
    }
}
