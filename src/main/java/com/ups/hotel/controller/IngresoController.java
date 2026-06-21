package com.ups.hotel.controller;

import com.ups.hotel.model.Ingreso;
import com.ups.hotel.service.IngresoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {
    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @GetMapping
    public List<Ingreso> findAll() {
        return ingresoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingreso> findById(@PathVariable Long id) {
        return ingresoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ingreso create(@RequestBody Ingreso ingreso) {
        return ingresoService.save(ingreso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingreso> update(@PathVariable Long id, @RequestBody Ingreso ingreso) {
        return ingresoService.findById(id)
                .map(existing -> {
                    ingreso.setId(existing.getId());
                    return ResponseEntity.ok(ingresoService.save(ingreso));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ingresoService.findById(id).isPresent()) {
            ingresoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
