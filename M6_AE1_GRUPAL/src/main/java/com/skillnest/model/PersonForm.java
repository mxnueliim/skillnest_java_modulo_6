package com.skillnest.model;

import jakarta.validation.constraints.*;

public class PersonForm {
  @NotBlank(message = "El nombre es obligatorio")
  private String nombre;

  @NotNull(message = "La edad es obligatoria")
  @Min(value = 1, message = "Edad mínima 1")
  @Max(value = 120, message = "Edad máxima 120")
  private Integer edad;

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public Integer getEdad() { return edad; }
  public void setEdad(Integer edad) { this.edad = edad; }
}
