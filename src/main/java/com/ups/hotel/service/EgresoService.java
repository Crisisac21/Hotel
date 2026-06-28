package com.ups.hotel.service;

import com.ups.hotel.entity.Egreso;

import java.util.List;
import java.util.Optional;

public interface EgresoService {
    List<Egreso> findAll();
    Optional<Egreso> findById(Long id);
    Egreso save(Egreso egreso);
    Egreso update(Long id, Egreso egreso);
    void deleteById(Long id);
}
