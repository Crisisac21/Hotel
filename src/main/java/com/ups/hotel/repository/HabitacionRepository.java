package com.ups.hotel.repository;

import com.ups.hotel.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    Optional<Habitacion> findByNumero(String numero);
    List<Habitacion> findByDisponibleTrue();

    @Query("SELECT h FROM Habitacion h WHERE h.disponible = true AND h.id NOT IN " +
            "(SELECT r.habitacion.id FROM Reserva r WHERE r.estado = 'CONFIRMADA' " +
            "AND ((r.fechaIngreso <= :endDate AND r.fechaSalida >= :startDate)))")
    List<Habitacion> findDisponiblesEnPeriodo(@Param("startDate") LocalDate startDate,
                                              @Param("endDate") LocalDate endDate);
}
