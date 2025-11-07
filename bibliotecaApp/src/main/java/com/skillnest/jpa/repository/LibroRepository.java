package com.skillnest.jpa.repository;

import com.skillnest.jpa.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    List<LibroEntity> findByAnioPublicacion(Integer anioPublicacion);
    List<LibroEntity> findByAutor_Id(Long autorId);
}
