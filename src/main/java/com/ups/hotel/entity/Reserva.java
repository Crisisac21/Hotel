package com.ups.hotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El cliente es obligatorio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull(message = "La habitación es obligatoria")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    private LocalDate fechaIngreso;

    @NotNull(message = "La fecha de salida es obligatoria")
    private LocalDate fechaSalida;

    @NotBlank(message = "El estado de la reserva es obligatorio")
    private String estado;

    @NotNull(message = "El total de la reserva es obligatorio")
    private BigDecimal total;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    private Factura factura;

    public Reserva() {
    }

    public Reserva(Long id, Cliente cliente, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida, String estado, BigDecimal total, Factura factura) {
        this.id = id;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.total = total;
        this.factura = factura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
