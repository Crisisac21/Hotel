package com.ups.hotel.service.impl;

import com.ups.hotel.dto.ReporteDto;
import com.ups.hotel.entity.Egreso;
import com.ups.hotel.entity.Factura;
import com.ups.hotel.entity.Habitacion;
import com.ups.hotel.entity.Ingreso;
import com.ups.hotel.entity.Reserva;
import com.ups.hotel.repository.EgresoRepository;
import com.ups.hotel.repository.FacturaRepository;
import com.ups.hotel.repository.HabitacionRepository;
import com.ups.hotel.repository.IngresoRepository;
import com.ups.hotel.repository.ReservaRepository;
import com.ups.hotel.service.ReporteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {
    private final ReservaRepository reservaRepository;
    private final HabitacionRepository habitacionRepository;
    private final FacturaRepository facturaRepository;
    private final IngresoRepository ingresoRepository;
    private final EgresoRepository egresoRepository;

    public ReporteServiceImpl(ReservaRepository reservaRepository,
                              HabitacionRepository habitacionRepository,
                              FacturaRepository facturaRepository,
                              IngresoRepository ingresoRepository,
                              EgresoRepository egresoRepository) {
        this.reservaRepository = reservaRepository;
        this.habitacionRepository = habitacionRepository;
        this.facturaRepository = facturaRepository;
        this.ingresoRepository = ingresoRepository;
        this.egresoRepository = egresoRepository;
    }

    @Override
    public ReporteDto crearResumen() {
        List<Reserva> reservas = reservaRepository.findAll();
        List<Habitacion> habitaciones = habitacionRepository.findByDisponibleTrue();
        List<Factura> facturas = facturaRepository.findAll();
        List<Ingreso> ingresos = ingresoRepository.findAll();
        List<Egreso> egresos = egresoRepository.findAll();

        BigDecimal totalIngresos = ingresos.stream()
                .map(Ingreso::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalEgresos = egresos.stream()
                .map(Egreso::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal balance = totalIngresos.subtract(totalEgresos);

        return new ReporteDto(
                (long) reservas.size(),
                (long) habitaciones.size(),
                totalIngresos,
                totalEgresos,
                balance
        );
    }
}
