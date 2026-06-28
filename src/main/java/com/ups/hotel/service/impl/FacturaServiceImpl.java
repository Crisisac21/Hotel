package com.ups.hotel.service.impl;

import com.ups.hotel.entity.Factura;
import com.ups.hotel.entity.Reserva;
import com.ups.hotel.exception.BusinessException;
import com.ups.hotel.exception.ResourceNotFoundException;
import com.ups.hotel.repository.FacturaRepository;
import com.ups.hotel.repository.ReservaRepository;
import com.ups.hotel.service.FacturaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {
    private final FacturaRepository facturaRepository;
    private final ReservaRepository reservaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository, ReservaRepository reservaRepository) {
        this.facturaRepository = facturaRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> findById(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public void deleteById(Long id) {
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada con id: " + id));
        facturaRepository.delete(factura);
    }

    @Override
    public Factura emitirFactura(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + reservaId));

        Optional<Factura> existing = facturaRepository.findByReservaId(reservaId);
        if (existing.isPresent()) {
            return existing.get();
        }

        if (reserva.getTotal() == null) {
            throw new BusinessException("No se puede generar factura para una reserva sin total definido");
        }

        Factura factura = new Factura(
                null,
                reserva,
                LocalDate.now(),
                reserva.getTotal(),
                "EMITIDA",
                "Factura generada para reserva " + reservaId,
                null
        );

        return facturaRepository.save(factura);
    }
}
