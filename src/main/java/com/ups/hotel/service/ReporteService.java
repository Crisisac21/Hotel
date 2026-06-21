package com.ups.hotel.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReporteService {
    private final ReservaService reservaService;
    private final ClienteService clienteService;
    private final HabitacionService habitacionService;
    private final FacturaService facturaService;

    public ReporteService(ReservaService reservaService,
                          ClienteService clienteService,
                          HabitacionService habitacionService,
                          FacturaService facturaService) {
        this.reservaService = reservaService;
        this.clienteService = clienteService;
        this.habitacionService = habitacionService;
        this.facturaService = facturaService;
    }

    public Map<String, Object> getResumen() {
        Map<String, Object> resumen = new HashMap<>();
        resumen.put("totalReservas", reservaService.findAll().size());
        resumen.put("totalClientes", clienteService.findAll().size());
        resumen.put("totalHabitaciones", habitacionService.findAll().size());
        resumen.put("totalFacturas", facturaService.findAll().size());
        return resumen;
    }
}
