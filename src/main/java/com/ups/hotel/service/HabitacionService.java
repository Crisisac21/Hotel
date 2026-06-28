package com.ups.hotel.service;

import com.ups.hotel.entity.Habitacion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitacionService {
    List<Habitacion> findAll();
    Optional<Habitacion> findById(Long id);
    Habitacion save(Habitacion habitacion);
    Habitacion update(Long id, Habitacion habitacion);
    void deleteById(Long id);
    List<Habitacion> findAvailable();
    List<Habitacion> findDisponibles(LocalDate fechaIngreso, LocalDate fechaSalida);
}
