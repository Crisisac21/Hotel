package com.ups.hotel.controller;

import com.ups.hotel.entity.Egreso;
import com.ups.hotel.service.EgresoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/egresos")
public class EgresoController {
    private final EgresoService egresoService;

    public EgresoController(EgresoService egresoService) {
        this.egresoService = egresoService;
    }

    @GetMapping
    public List<Egreso> findAll() {
        return egresoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Egreso> findById(@PathVariable Long id) {
        return egresoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Egreso create(@RequestBody Egreso egreso) {
        return egresoService.save(egreso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Egreso> update(@PathVariable Long id, @RequestBody Egreso egreso) {
        return egresoService.findById(id)
                .map(existing -> {
                    egreso.setId(existing.getId());
                    return ResponseEntity.ok(egresoService.save(egreso));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (egresoService.findById(id).isPresent()) {
            egresoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
