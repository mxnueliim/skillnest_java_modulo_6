package com.skillnest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillnest.web.models.CuentaUsuario;

public interface CuentaUsuarioRepository extends JpaRepository<CuentaUsuario, Long> {

}
