package com.skillnest.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnest.web.models.Producto;
import com.skillnest.web.models.ProductoDto;
import com.skillnest.web.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
    public String obtenerMensaje() {
        return "¡Servicio funcionando!";
    }
	
    @Override
    public String formatearProducto(String nombre, double precio) {
        return "Producto: " + nombre + ", Precio: $" + precio;
    }

	@Override
	public Producto guardaProducto(ProductoDto productoDto) {
		Producto producto = new Producto();
		producto.setNombre(productoDto.getNombre());
		producto.setCantidad(productoDto.getCantidad());
		producto.setPrecio(productoDto.getPrecio());
		producto.setDetalle(productoDto.getDetalle());
		
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> listarTodos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto obtener(Long id) {
		return productoRepository.findById(id).get();
	}

	@Override //api
	public Producto crear(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto eliminar(long id) {
		Producto producto = null;
		if (productoRepository.existsById(id)) {
			producto = this.obtener(id);
			productoRepository.delete(producto);
		}
		return producto;
	}

	@Override
	public Producto actualizar(long id, Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}
    
	
    
}

