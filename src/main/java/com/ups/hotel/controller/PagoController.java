package com.ups.hotel.controller;

import com.ups.hotel.dto.PagoDto;
import com.ups.hotel.entity.Factura;
import com.ups.hotel.entity.Pago;
import com.ups.hotel.service.FacturaService;
import com.ups.hotel.service.PagoService;
import com.ups.hotel.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    private final PagoService pagoService;
    private final FacturaService facturaService;
    private final MapperUtil mapper;

    public PagoController(PagoService pagoService, FacturaService facturaService, MapperUtil mapper) {
        this.pagoService = pagoService;
        this.facturaService = facturaService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PagoDto> findAll() {
        return pagoService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDto> findById(@PathVariable Long id) {
        return pagoService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PagoDto> create(@Valid @RequestBody PagoDto pagoDto) {
        Factura factura = facturaService.findById(pagoDto.getFacturaId())
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada"));
        Pago pago = mapper.toEntity(pagoDto, factura);
        Pago saved = pagoService.save(pago);
        return ResponseEntity.created(URI.create("/api/pagos/" + saved.getId()))
                .body(mapper.toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (pagoService.findById(id).isPresent()) {
            pagoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
