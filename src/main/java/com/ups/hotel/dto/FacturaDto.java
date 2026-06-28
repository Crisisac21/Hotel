package com.ups.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FacturaDto {
    private Long id;

    @NotNull(message = "La reserva es obligatoria")
    private Long reservaId;

    private LocalDate fechaEmision;

    @NotNull(message = "El total es obligatorio")
    private BigDecimal total;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    private String descripcion;
    private Long reservaNumero;

    public FacturaDto() {
    }

    public FacturaDto(Long id, Long reservaId, LocalDate fechaEmision, BigDecimal total, String estado, String descripcion, Long reservaNumero) {
        this.id = id;
        this.reservaId = reservaId;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.estado = estado;
        this.descripcion = descripcion;
        this.reservaNumero = reservaNumero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getReservaNumero() {
        return reservaNumero;
    }

    public void setReservaNumero(Long reservaNumero) {
        this.reservaNumero = reservaNumero;
    }
}
