package com.skillnest.web.models;

public class ProductoDto {

	private Long id;
	private String nombre;
	private String detalle;
	private int cantidad;
	private Double precio; 
	
	//contructores
	
	public ProductoDto(String nombre, String detalle, int cantidad, Double precio) {
		super();
		this.nombre = nombre;
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	
	
	//Getters&Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
