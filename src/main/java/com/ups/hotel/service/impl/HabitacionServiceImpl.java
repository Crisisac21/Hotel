package com.ups.hotel.service.impl;

import com.ups.hotel.entity.Habitacion;
import com.ups.hotel.exception.ResourceNotFoundException;
import com.ups.hotel.repository.HabitacionRepository;
import com.ups.hotel.service.HabitacionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HabitacionServiceImpl implements HabitacionService {
    private final HabitacionRepository habitacionRepository;

    public HabitacionServiceImpl(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    @Override
    public List<Habitacion> findAll() {
        return habitacionRepository.findAll();
    }

    @Override
    public Optional<Habitacion> findById(Long id) {
        return habitacionRepository.findById(id);
    }

    @Override
    public Habitacion save(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Habitacion update(Long id, Habitacion habitacion) {
        Habitacion existing = habitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada con id: " + id));
        existing.setNumero(habitacion.getNumero());
        existing.setTipo(habitacion.getTipo());
        existing.setPrecio(habitacion.getPrecio());
        existing.setDisponible(habitacion.getDisponible());
        return habitacionRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        Habitacion existing = habitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada con id: " + id));
        habitacionRepository.delete(existing);
    }

    @Override
    public List<Habitacion> findAvailable() {
        return habitacionRepository.findByDisponibleTrue();
    }

    @Override
    public List<Habitacion> findDisponibles(LocalDate fechaIngreso, LocalDate fechaSalida) {
        if (fechaIngreso == null || fechaSalida == null || !fechaIngreso.isBefore(fechaSalida)) {
            return habitacionRepository.findByDisponibleTrue();
        }
        return habitacionRepository.findDisponiblesEnPeriodo(fechaIngreso, fechaSalida);
    }
}
