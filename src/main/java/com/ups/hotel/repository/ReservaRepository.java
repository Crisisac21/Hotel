package com.ups.hotel.repository;

import com.ups.hotel.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEstado(String estado);
    List<Reserva> findByFechaIngresoBetween(LocalDate startDate, LocalDate endDate);
}
