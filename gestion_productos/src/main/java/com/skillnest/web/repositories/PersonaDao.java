package com.skillnest.web.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.skillnest.web.models.PersonaDTO;
import com.skillnest.web.rowmapers.PersonaRowMapper;

@Repository
public class PersonaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Métodos CRUD aquí
    
    public List<PersonaDTO> obtenerTodas() {
        String sql = "SELECT * FROM personas";
        return jdbcTemplate.query(sql, new PersonaRowMapper());
    }

    public PersonaDTO obtenerPorId(Long id) {
        String sql = "SELECT * FROM personas WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new PersonaRowMapper(), id);
    }
    
    public PersonaDTO obtenerPorEmail(String email) {
        String sql = "SELECT * FROM personas WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new PersonaRowMapper(), email);
    }
    
 // INSERT
    public int insertar(PersonaDTO persona) {
        String sql = "INSERT INTO personas (nombre, email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, persona.getNombre(), persona.getEmail());
    }

    // UPDATE
    public int actualizar(PersonaDTO persona) {
        String sql = "UPDATE personas SET nombre = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, persona.getNombre(), persona.getEmail(), persona.getId());
    }

    // DELETE
    public int eliminar(Long id) {
        String sql = "DELETE FROM personas WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
