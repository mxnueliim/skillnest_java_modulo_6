package com.skillnest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillnest.web.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
