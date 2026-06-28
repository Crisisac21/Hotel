package com.ups.hotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número de habitación es obligatorio")
    @Column(unique = true)
    private String numero;

    @NotBlank(message = "El tipo de habitación es obligatorio")
    private String tipo;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que cero")
    private BigDecimal precio;

    @NotNull(message = "La disponibilidad debe indicarse")
    private Boolean disponible;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas = new ArrayList<>();

    public Habitacion() {
        this.reservas = new ArrayList<>();
    }

    public Habitacion(Long id, String numero, String tipo, BigDecimal precio, Boolean disponible, List<Reserva> reservas) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
        this.reservas = reservas == null ? new ArrayList<>() : reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas == null ? new ArrayList<>() : reservas;
    }
}
