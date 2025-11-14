package com.skillnest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillnest.web.models.Estudiante;

//@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByEmail(String email);
}
