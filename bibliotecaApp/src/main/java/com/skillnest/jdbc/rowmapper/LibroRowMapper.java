package com.skillnest.jdbc.rowmapper;

import com.skillnest.jdbc.model.Libro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroRowMapper implements RowMapper<Libro> {
    @Override
    public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Libro l = new Libro();
        l.setId(rs.getLong("id"));
        l.setTitulo(rs.getString("titulo"));
        l.setAnioPublicacion(rs.getInt("anio_publicacion"));
        return l;
    }
}
