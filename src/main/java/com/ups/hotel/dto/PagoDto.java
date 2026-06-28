package com.ups.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagoDto {
    private Long id;

    @NotNull(message = "La factura es obligatoria")
    private Long facturaId;

    @NotNull(message = "La fecha de pago es obligatoria")
    private LocalDate fechaPago;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor que cero")
    private BigDecimal monto;

    @NotBlank(message = "El método de pago es obligatorio")
    private String metodo;

    @NotBlank(message = "El estado del pago es obligatorio")
    private String estado;

    public PagoDto() {
    }

    public PagoDto(Long id, Long facturaId, LocalDate fechaPago, BigDecimal monto, String metodo, String estado) {
        this.id = id;
        this.facturaId = facturaId;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.metodo = metodo;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
