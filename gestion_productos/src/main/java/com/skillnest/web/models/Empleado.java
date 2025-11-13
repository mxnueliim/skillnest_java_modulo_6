package com.skillnest.web.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private String puesto;
  
   @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private CuentaUsuario cuentaUsuario;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "departamento_id")
   private Departamento departamento;
   
   // Constructor
   public Empleado() {
	super();
   }

   public Empleado(Long id, String nombre, String puesto, CuentaUsuario cuentaUsuario) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.puesto = puesto;
	this.cuentaUsuario = cuentaUsuario;
   }
   
   // Getters y setters
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

   public String getPuesto() {
	return puesto;
   }

   public void setPuesto(String puesto) {
	this.puesto = puesto;
   }

   public CuentaUsuario getCuentaUsuario() {
	return cuentaUsuario;
   }

   public void setCuentaUsuario(CuentaUsuario cuentaUsuario) {
	this.cuentaUsuario = cuentaUsuario;
   }
  
   public Departamento getDepartamento() {
		return departamento;
	}

   public void setDepartamento(Departamento departamento) {
	   this.departamento = departamento;
   }
   
   
}
