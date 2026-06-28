package com.ups.hotel.controller;

import com.ups.hotel.entity.Habitacion;
import com.ups.hotel.service.HabitacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {
    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    public List<Habitacion> findAll() {
        return habitacionService.findAll();
    }

    @GetMapping("/available")
    public List<Habitacion> findAvailable() {
        return habitacionService.findAvailable();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> findById(@PathVariable Long id) {
        return habitacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Habitacion create(@RequestBody Habitacion habitacion) {
        return habitacionService.save(habitacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> update(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        return habitacionService.findById(id)
                .map(existing -> {
                    habitacion.setId(existing.getId());
                    return ResponseEntity.ok(habitacionService.save(habitacion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (habitacionService.findById(id).isPresent()) {
            habitacionService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
