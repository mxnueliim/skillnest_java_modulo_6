package com.skillnest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillnest.web.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
//public interface PersonaRepository extends CrudRepository<Persona, Long> {
//	List<Persona> findAll();
	
	Persona findByEmail(String email);
}
