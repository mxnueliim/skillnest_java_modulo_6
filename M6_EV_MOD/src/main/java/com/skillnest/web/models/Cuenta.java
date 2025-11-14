package com.skillnest.web.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;

	   private double saldo;
	   
	   //agregar
	   //numero cuenta
	   //relacion con usuario/persona/empleado
	   
	   public Long getId() {
		   return id;
	   }

	   public void setId(Long id) {
		   this.id = id;
	   }

	   public double getSaldo() {
		   return saldo;
	   }

	   public void setSaldo(double saldo) {
		   this.saldo = saldo;
	   }
	   
	   
}
