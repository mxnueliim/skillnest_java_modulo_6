package com.skillnest.web.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departamentos")
public class Departamento {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nombre;

   @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Empleado> empleados;

   // Constructor
   public Departamento() {
	super();
   }

   public Departamento(Long id, String nombre) {
	super();
	this.id = id;
	this.nombre = nombre;
   }

   // getters y setters
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

   public List<Empleado> getEmpleados() {
	return empleados;
   }

   public void setEmpleados(List<Empleado> empleados) {
	this.empleados = empleados;
   }


   
}
