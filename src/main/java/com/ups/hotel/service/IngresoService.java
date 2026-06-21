package com.ups.hotel.service;

import com.ups.hotel.model.Ingreso;
import com.ups.hotel.repository.IngresoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngresoService {
    private final IngresoRepository ingresoRepository;

    public IngresoService(IngresoRepository ingresoRepository) {
        this.ingresoRepository = ingresoRepository;
    }

    public List<Ingreso> findAll() {
        return ingresoRepository.findAll();
    }

    public Optional<Ingreso> findById(Long id) {
        return ingresoRepository.findById(id);
    }

    public Ingreso save(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    public void deleteById(Long id) {
        ingresoRepository.deleteById(id);
    }
}
