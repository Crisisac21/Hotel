package com.ups.hotel.controller;

import com.ups.hotel.dto.ReporteDto;
import com.ups.hotel.service.ReporteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/resumen")
    public Map<String, Object> getResumen() {
        ReporteDto resumen = reporteService.crearResumen();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("totalReservas", resumen.getTotalReservas());
        response.put("habitacionesDisponibles", resumen.getHabitacionesDisponibles());
        response.put("ingresosTotales", resumen.getIngresosTotales());
        response.put("egresosTotales", resumen.getEgresosTotales());
        response.put("balance", resumen.getBalance());
        return response;
    }
}
