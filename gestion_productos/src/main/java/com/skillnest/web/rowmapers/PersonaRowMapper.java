package com.skillnest.web.rowmapers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.skillnest.web.models.PersonaDTO;

public class PersonaRowMapper implements RowMapper<PersonaDTO> {
    
	@Override
    public PersonaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonaDTO persona = new PersonaDTO();
        persona.setId(rs.getInt("id"));
        persona.setNombre(rs.getString("nombre"));
        persona.setEmail(rs.getString("email"));
        return persona;
    }


}
