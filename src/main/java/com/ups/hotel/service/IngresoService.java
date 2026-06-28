package com.ups.hotel.service;

import com.ups.hotel.entity.Ingreso;

import java.util.List;
import java.util.Optional;

public interface IngresoService {
    List<Ingreso> findAll();
    Optional<Ingreso> findById(Long id);
    Ingreso save(Ingreso ingreso);
    Ingreso update(Long id, Ingreso ingreso);
    void deleteById(Long id);
}
