package com.skillnest.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnest.web.models.Cuenta;
import com.skillnest.web.repositories.CuentaRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferenciaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Transactional
    public void transferirDinero(Long cuentaOrigenId, Long cuentaDestinoId, double monto) {
        Cuenta origen = cuentaRepository.findById(cuentaOrigenId).orElseThrow();
        Cuenta destino = cuentaRepository.findById(cuentaDestinoId).orElseThrow();

        if (origen.getSaldo() < monto) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }

        origen.setSaldo(origen.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);

        cuentaRepository.save(origen);
        cuentaRepository.save(destino);
    }
}
