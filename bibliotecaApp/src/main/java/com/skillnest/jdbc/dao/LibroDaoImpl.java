package com.skillnest.jdbc.dao;

import com.skillnest.jdbc.model.Libro;
import com.skillnest.jdbc.rowmapper.LibroRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class LibroDaoImpl implements LibroDao {

    private final JdbcTemplate jdbc;

    public LibroDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Long insert(Libro libro) {
        final String sql = "INSERT INTO libros (titulo, anio_publicacion) VALUES (?, ?)";
        KeyHolder kh = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, libro.getTitulo());
            ps.setInt(2, libro.getAnioPublicacion());
            return ps;
        }, kh);
        return (kh.getKey() == null) ? null : Objects.requireNonNull(kh.getKey()).longValue();
    }

    @Override
    public List<Libro> findAll() {
        final String sql = "SELECT id, titulo, anio_publicacion FROM libros ORDER BY id";
        return jdbc.query(sql, new LibroRowMapper());
    }

    @Override
    public List<Libro> findByAnio(int anioPublicacion) {
        final String sql = "SELECT id, titulo, anio_publicacion FROM libros WHERE anio_publicacion = ? ORDER BY id";
        return jdbc.query(sql, new LibroRowMapper(), anioPublicacion);
    }

    @Override
    public int updateTitulo(Long id, String nuevoTitulo) {
        final String sql = "UPDATE libros SET titulo = ? WHERE id = ?";
        return jdbc.update(sql, nuevoTitulo, id);
    }

    @Override
    public int deleteById(Long id) {
        final String sql = "DELETE FROM libros WHERE id = ?";
        return jdbc.update(sql, id);
    }
}
