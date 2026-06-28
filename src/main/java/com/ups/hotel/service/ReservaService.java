package com.ups.hotel.service;

import com.ups.hotel.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Reserva save(Reserva reserva);
    Reserva update(Long id, Reserva reserva);
    void deleteById(Long id);
    Reserva reservar(Reserva reserva);
    Reserva cancelar(Long id);
}
