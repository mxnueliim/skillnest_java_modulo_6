package com.skillnest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillnest.web.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
