package com.ups.hotel.controller;

import com.ups.hotel.dto.ClienteDto;
import com.ups.hotel.entity.Cliente;
import com.ups.hotel.service.ClienteService;
import com.ups.hotel.util.MapperUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    private final MapperUtil mapper;

    public ClienteController(ClienteService clienteService, MapperUtil mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ClienteDto> findAll() {
        return clienteService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        return clienteService.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteDto> create(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente cliente = mapper.toEntity(clienteDto);
        Cliente saved = clienteService.save(cliente);
        return ResponseEntity.created(URI.create("/api/clientes/" + saved.getId()))
                .body(mapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable Long id, @Valid @RequestBody ClienteDto clienteDto) {
        Cliente cliente = mapper.toEntity(clienteDto);
        return clienteService.findById(id)
                .map(existing -> ResponseEntity.ok(mapper.toDto(clienteService.update(id, cliente))))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
