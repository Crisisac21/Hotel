package com.ups.hotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La reserva asociada es obligatoria")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id", unique = true)
    private Reserva reserva;

    @NotNull(message = "La fecha de emisión es obligatoria")
    private LocalDate fechaEmision;

    @NotNull(message = "El total de la factura es obligatorio")
    private BigDecimal total;

    @NotBlank(message = "El estado de la factura es obligatorio")
    private String estado;

    private String descripcion;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos = new ArrayList<>();

    public Factura() {
        this.pagos = new ArrayList<>();
    }

    public Factura(Long id, Reserva reserva, LocalDate fechaEmision, BigDecimal total, String estado, String descripcion, List<Pago> pagos) {
        this.id = id;
        this.reserva = reserva;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.estado = estado;
        this.descripcion = descripcion;
        this.pagos = pagos == null ? new ArrayList<>() : pagos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos == null ? new ArrayList<>() : pagos;
    }
}
