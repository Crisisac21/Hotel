package com.ups.hotel.service.impl;

import com.ups.hotel.entity.Ingreso;
import com.ups.hotel.exception.ResourceNotFoundException;
import com.ups.hotel.repository.IngresoRepository;
import com.ups.hotel.service.IngresoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngresoServiceImpl implements IngresoService {
    private final IngresoRepository ingresoRepository;

    public IngresoServiceImpl(IngresoRepository ingresoRepository) {
        this.ingresoRepository = ingresoRepository;
    }

    @Override
    public List<Ingreso> findAll() {
        return ingresoRepository.findAll();
    }

    @Override
    public Optional<Ingreso> findById(Long id) {
        return ingresoRepository.findById(id);
    }

    @Override
    public Ingreso save(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    @Override
    public Ingreso update(Long id, Ingreso ingreso) {
        Ingreso existing = ingresoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingreso no encontrado con id: " + id));
        existing.setDescripcion(ingreso.getDescripcion());
        existing.setMonto(ingreso.getMonto());
        existing.setFecha(ingreso.getFecha());
        existing.setCategoria(ingreso.getCategoria());
        return ingresoRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        Ingreso existing = ingresoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingreso no encontrado con id: " + id));
        ingresoRepository.delete(existing);
    }
}
