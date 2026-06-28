package com.ups.hotel.controller;

import com.ups.hotel.dto.ReservaDto;
import com.ups.hotel.entity.Cliente;
import com.ups.hotel.entity.Habitacion;
import com.ups.hotel.entity.Reserva;
import com.ups.hotel.service.ClienteService;
import com.ups.hotel.service.HabitacionService;
import com.ups.hotel.service.ReservaService;
import com.ups.hotel.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaService reservaService;
    private final ClienteService clienteService;
    private final HabitacionService habitacionService;
    private final MapperUtil mapper;

    public ReservaController(ReservaService reservaService,
                             ClienteService clienteService,
                             HabitacionService habitacionService,
                             MapperUtil mapper) {
        this.reservaService = reservaService;
        this.clienteService = clienteService;
        this.habitacionService = habitacionService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ReservaDto> findAll() {
        return reservaService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> findById(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservaDto> create(@Valid @RequestBody ReservaDto reservaDto) {
        Cliente cliente = clienteService.findById(reservaDto.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        Habitacion habitacion = habitacionService.findById(reservaDto.getHabitacionId())
                .orElseThrow(() -> new IllegalArgumentException("Habitación no encontrada"));
        Reserva reserva = mapper.toEntity(reservaDto, cliente, habitacion);
        Reserva saved = reservaService.reservar(reserva);
        return ResponseEntity.created(URI.create("/api/reservas/" + saved.getId()))
                .body(mapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDto> update(@PathVariable Long id, @Valid @RequestBody ReservaDto reservaDto) {
        Cliente cliente = clienteService.findById(reservaDto.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        Habitacion habitacion = habitacionService.findById(reservaDto.getHabitacionId())
                .orElseThrow(() -> new IllegalArgumentException("Habitación no encontrada"));
        Reserva reserva = mapper.toEntity(reservaDto, cliente, habitacion);
        return reservaService.findById(id)
                .map(existing -> ResponseEntity.ok(mapper.toDto(reservaService.update(id, reserva))))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (reservaService.findById(id).isPresent()) {
            reservaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<ReservaDto> cancelar(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(existing -> ResponseEntity.ok(mapper.toDto(reservaService.cancelar(id))))
                .orElse(ResponseEntity.notFound().build());
    }
}
