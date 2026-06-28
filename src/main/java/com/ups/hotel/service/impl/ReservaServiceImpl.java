package com.ups.hotel.service.impl;

import com.ups.hotel.entity.Cliente;
import com.ups.hotel.entity.Habitacion;
import com.ups.hotel.entity.Reserva;
import com.ups.hotel.exception.BusinessException;
import com.ups.hotel.exception.ResourceNotFoundException;
import com.ups.hotel.repository.ReservaRepository;
import com.ups.hotel.service.ClienteService;
import com.ups.hotel.service.HabitacionService;
import com.ups.hotel.service.ReservaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final ClienteService clienteService;
    private final HabitacionService habitacionService;

    public ReservaServiceImpl(ReservaRepository reservaRepository,
                              ClienteService clienteService,
                              HabitacionService habitacionService) {
        this.reservaRepository = reservaRepository;
        this.clienteService = clienteService;
        this.habitacionService = habitacionService;
    }

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva update(Long id, Reserva reserva) {
        Reserva existing = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + id));
        existing.setFechaIngreso(reserva.getFechaIngreso());
        existing.setFechaSalida(reserva.getFechaSalida());
        existing.setEstado(reserva.getEstado());
        existing.setTotal(reserva.getTotal());
        return reservaRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        Reserva existing = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + id));
        reservaRepository.delete(existing);
    }

    @Override
    public Reserva reservar(Reserva reserva) {
        Cliente cliente = reserva.getCliente();
        Habitacion habitacion = reserva.getHabitacion();
        if (cliente == null || habitacion == null) {
            throw new BusinessException("Cliente y habitación son obligatorios para crear una reserva");
        }
        if (!reserva.getFechaIngreso().isBefore(reserva.getFechaSalida())) {
            throw new BusinessException("La fecha de ingreso debe ser anterior a la fecha de salida");
        }
        List<Habitacion> disponibles = habitacionService.findDisponibles(reserva.getFechaIngreso(), reserva.getFechaSalida());
        boolean habitacionDisponible = disponibles.stream().anyMatch(h -> h.getId().equals(habitacion.getId()));
        if (!habitacionDisponible) {
            throw new BusinessException("La habitación no está disponible en el rango seleccionado");
        }
        habitacion.setDisponible(false);
        reserva.setEstado("CONFIRMADA");
        long dias = LocalDate.from(reserva.getFechaIngreso()).until(reserva.getFechaSalida()).getDays();
        if (dias <= 0) {
            throw new BusinessException("El rango de fechas de la reserva no es válido");
        }
        reserva.setTotal(habitacion.getPrecio().multiply(java.math.BigDecimal.valueOf(dias)));
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva cancelar(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + id));
        reserva.setEstado("CANCELADA");
        Habitacion habitacion = reserva.getHabitacion();
        if (habitacion != null) {
            habitacion.setDisponible(true);
        }
        return reservaRepository.save(reserva);
    }
}
