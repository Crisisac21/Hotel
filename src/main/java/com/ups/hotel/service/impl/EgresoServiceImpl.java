package com.ups.hotel.service.impl;

import com.ups.hotel.entity.Egreso;
import com.ups.hotel.exception.ResourceNotFoundException;
import com.ups.hotel.repository.EgresoRepository;
import com.ups.hotel.service.EgresoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EgresoServiceImpl implements EgresoService {
    private final EgresoRepository egresoRepository;

    public EgresoServiceImpl(EgresoRepository egresoRepository) {
        this.egresoRepository = egresoRepository;
    }

    @Override
    public List<Egreso> findAll() {
        return egresoRepository.findAll();
    }

    @Override
    public Optional<Egreso> findById(Long id) {
        return egresoRepository.findById(id);
    }

    @Override
    public Egreso save(Egreso egreso) {
        return egresoRepository.save(egreso);
    }

    @Override
    public Egreso update(Long id, Egreso egreso) {
        Egreso existing = egresoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Egreso no encontrado con id: " + id));
        existing.setDescripcion(egreso.getDescripcion());
        existing.setMonto(egreso.getMonto());
        existing.setFecha(egreso.getFecha());
        existing.setCategoria(egreso.getCategoria());
        return egresoRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        Egreso existing = egresoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Egreso no encontrado con id: " + id));
        egresoRepository.delete(existing);
    }
}
