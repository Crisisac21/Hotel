package com.ups.hotel.controller;

import com.ups.hotel.dto.FacturaDto;
import com.ups.hotel.entity.Factura;
import com.ups.hotel.service.FacturaService;
import com.ups.hotel.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    private final FacturaService facturaService;
    private final MapperUtil mapper;

    public FacturaController(FacturaService facturaService, MapperUtil mapper) {
        this.facturaService = facturaService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<FacturaDto> findAll() {
        return facturaService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDto> findById(@PathVariable Long id) {
        return facturaService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/emitir")
    public ResponseEntity<FacturaDto> emitir(@RequestParam Long reservaId) {
        Factura factura = facturaService.emitirFactura(reservaId);
        return ResponseEntity.created(URI.create("/api/facturas/" + factura.getId()))
                .body(mapper.toDto(factura));
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
