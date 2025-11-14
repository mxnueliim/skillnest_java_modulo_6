package com.skillnest.web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cuenta_usuarios")
public class CuentaUsuario {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombreUsuario;
   private String contrasena;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "empleado_id")
   private Empleado empleado;
   
   // Constructor

   public CuentaUsuario() {
	super();
   }

   public CuentaUsuario(Long id, String nombreUsuario, String contrasena, Empleado empleado) {
	super();
	this.id = id;
	this.nombreUsuario = nombreUsuario;
	this.contrasena = contrasena;
	this.empleado = empleado;
   }
   // Getters y setters

   public Long getId() {
	return id;
   }

   public void setId(Long id) {
	this.id = id;
   }

   public String getNombreUsuario() {
	return nombreUsuario;
   }

   public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
   }

   public String getContrasena() {
	return contrasena;
   }

   public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
   }

   public Empleado getEmpleado() {
	return empleado;
   }

   public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
   }
   
}
