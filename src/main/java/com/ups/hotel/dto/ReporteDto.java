package com.ups.hotel.dto;

import java.math.BigDecimal;

public class ReporteDto {
    private Long totalReservas;
    private Long habitacionesDisponibles;
    private BigDecimal ingresosTotales;
    private BigDecimal egresosTotales;
    private BigDecimal balance;

    public ReporteDto() {
    }

    public ReporteDto(Long totalReservas, Long habitacionesDisponibles, BigDecimal ingresosTotales, BigDecimal egresosTotales, BigDecimal balance) {
        this.totalReservas = totalReservas;
        this.habitacionesDisponibles = habitacionesDisponibles;
        this.ingresosTotales = ingresosTotales;
        this.egresosTotales = egresosTotales;
        this.balance = balance;
    }

    public Long getTotalReservas() {
        return totalReservas;
    }

    public void setTotalReservas(Long totalReservas) {
        this.totalReservas = totalReservas;
    }

    public Long getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public void setHabitacionesDisponibles(Long habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public BigDecimal getIngresosTotales() {
        return ingresosTotales;
    }

    public void setIngresosTotales(BigDecimal ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }

    public BigDecimal getEgresosTotales() {
        return egresosTotales;
    }

    public void setEgresosTotales(BigDecimal egresosTotales) {
        this.egresosTotales = egresosTotales;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
