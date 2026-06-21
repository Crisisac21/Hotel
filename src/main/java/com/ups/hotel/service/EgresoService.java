package com.ups.hotel.service;

import com.ups.hotel.model.Egreso;
import com.ups.hotel.repository.EgresoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EgresoService {
    private final EgresoRepository egresoRepository;

    public EgresoService(EgresoRepository egresoRepository) {
        this.egresoRepository = egresoRepository;
    }

    public List<Egreso> findAll() {
        return egresoRepository.findAll();
    }

    public Optional<Egreso> findById(Long id) {
        return egresoRepository.findById(id);
    }

    public Egreso save(Egreso egreso) {
        return egresoRepository.save(egreso);
    }

    public void deleteById(Long id) {
        egresoRepository.deleteById(id);
    }
}
