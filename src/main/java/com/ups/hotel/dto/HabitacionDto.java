package com.ups.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class HabitacionDto {
    private Long id;

    @NotBlank(message = "El número de habitación es obligatorio")
    private String numero;

    @NotBlank(message = "El tipo de habitación es obligatorio")
    private String tipo;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que cero")
    private BigDecimal precio;

    @NotNull(message = "La disponibilidad es obligatoria")
    private Boolean disponible;

    public HabitacionDto() {
    }

    public HabitacionDto(Long id, String numero, String tipo, BigDecimal precio, Boolean disponible) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
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
}
