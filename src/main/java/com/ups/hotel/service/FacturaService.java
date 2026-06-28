package com.ups.hotel.service;

import com.ups.hotel.entity.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    List<Factura> findAll();
    Optional<Factura> findById(Long id);
    Factura save(Factura factura);
    void deleteById(Long id);
    Factura emitirFactura(Long reservaId);
}
