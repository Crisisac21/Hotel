package com.ups.hotel.service.impl;

import com.ups.hotel.entity.Factura;
import com.ups.hotel.entity.Pago;
import com.ups.hotel.exception.ResourceNotFoundException;
import com.ups.hotel.repository.FacturaRepository;
import com.ups.hotel.repository.PagoRepository;
import com.ups.hotel.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;
    private final FacturaRepository facturaRepository;

    public PagoServiceImpl(PagoRepository pagoRepository, FacturaRepository facturaRepository) {
        this.pagoRepository = pagoRepository;
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> findById(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago save(Pago pago) {
        Factura factura = facturaRepository.findById(pago.getFactura().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada con id: " + pago.getFactura().getId()));
        pago.setFactura(factura);
        return pagoRepository.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        Pago current = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id: " + id));
        pagoRepository.delete(current);
    }
}
