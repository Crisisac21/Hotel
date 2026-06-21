package com.ups.hotel.service;

import com.ups.hotel.model.Factura;
import com.ups.hotel.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> findById(Long id) {
        return facturaRepository.findById(id);
    }

    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }
}
