package com.ups.hotel.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservaDto {
    private Long id;

    @NotNull(message = "El cliente es obligatorio")
    private Long clienteId;

    @NotNull(message = "La habitación es obligatoria")
    private Long habitacionId;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    private LocalDate fechaIngreso;

    @NotNull(message = "La fecha de salida es obligatoria")
    private LocalDate fechaSalida;

    private String estado;
    private BigDecimal total;
    private String clienteNombre;
    private String habitacionNumero;

    public ReservaDto() {
    }

    public ReservaDto(Long id, Long clienteId, Long habitacionId, LocalDate fechaIngreso, LocalDate fechaSalida, String estado, BigDecimal total, String clienteNombre, String habitacionNumero) {
        this.id = id;
        this.clienteId = clienteId;
        this.habitacionId = habitacionId;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.total = total;
        this.clienteNombre = clienteNombre;
        this.habitacionNumero = habitacionNumero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Long habitacionId) {
        this.habitacionId = habitacionId;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getHabitacionNumero() {
        return habitacionNumero;
    }

    public void setHabitacionNumero(String habitacionNumero) {
        this.habitacionNumero = habitacionNumero;
    }
}
