package com.ups.hotel.controller;

import com.ups.hotel.model.Factura;
import com.ups.hotel.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> findAll() {
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> findById(@PathVariable Long id) {
        return facturaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Factura create(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> update(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.findById(id)
                .map(existing -> {
                    factura.setId(existing.getId());
                    return ResponseEntity.ok(facturaService.save(factura));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (facturaService.findById(id).isPresent()) {
            facturaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
