package com.skillnest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillnest.web.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
