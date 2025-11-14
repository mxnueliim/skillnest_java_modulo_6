package com.skillnest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillnest.web.models.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
