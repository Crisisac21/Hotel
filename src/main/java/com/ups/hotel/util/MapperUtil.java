package com.ups.hotel.util;

import com.ups.hotel.dto.*;
import com.ups.hotel.entity.*;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    public UsuarioDto toDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEmail(),
                usuario.getRol()
        );
    }

    public Usuario toEntity(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
        return new Usuario(
                dto.getId(),
                dto.getNombre(),
                dto.getUsername(),
                dto.getPassword(),
                dto.getEmail(),
                dto.getRol()
        );
    }

    public ClienteDto toDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return new ClienteDto(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getDocumento(),
                cliente.getDireccion()
        );
    }

    public Cliente toEntity(ClienteDto dto) {
        if (dto == null) {
            return null;
        }
        return new Cliente(
                dto.getId(),
                dto.getNombre(),
                dto.getTelefono(),
                dto.getEmail(),
                dto.getDocumento(),
                dto.getDireccion(),
                null
        );
    }

    public HabitacionDto toDto(Habitacion habitacion) {
        if (habitacion == null) {
            return null;
        }
        return new HabitacionDto(
                habitacion.getId(),
                habitacion.getNumero(),
                habitacion.getTipo(),
                habitacion.getPrecio(),
                habitacion.getDisponible()
        );
    }

    public Habitacion toEntity(HabitacionDto dto) {
        if (dto == null) {
            return null;
        }
        return new Habitacion(
                dto.getId(),
                dto.getNumero(),
                dto.getTipo(),
                dto.getPrecio(),
                dto.getDisponible(),
                null
        );
    }

    public ReservaDto toDto(Reserva reserva) {
        if (reserva == null) {
            return null;
        }
        return new ReservaDto(
                reserva.getId(),
                reserva.getCliente() == null ? null : reserva.getCliente().getId(),
                reserva.getHabitacion() == null ? null : reserva.getHabitacion().getId(),
                reserva.getFechaIngreso(),
                reserva.getFechaSalida(),
                reserva.getEstado(),
                reserva.getTotal(),
                reserva.getCliente() == null ? null : reserva.getCliente().getNombre(),
                reserva.getHabitacion() == null ? null : reserva.getHabitacion().getNumero()
        );
    }

    public Reserva toEntity(ReservaDto dto, Cliente cliente, Habitacion habitacion) {
        if (dto == null) {
            return null;
        }
        return new Reserva(
                dto.getId(),
                cliente,
                habitacion,
                dto.getFechaIngreso(),
                dto.getFechaSalida(),
                dto.getEstado(),
                dto.getTotal(),
                null
        );
    }

    public FacturaDto toDto(Factura factura) {
        if (factura == null) {
            return null;
        }
        return new FacturaDto(
                factura.getId(),
                factura.getReserva() == null ? null : factura.getReserva().getId(),
                factura.getFechaEmision(),
                factura.getTotal(),
                factura.getEstado(),
                factura.getDescripcion(),
                factura.getReserva() == null ? null : factura.getReserva().getId()
        );
    }

    public Factura toEntity(FacturaDto dto, Reserva reserva) {
        if (dto == null) {
            return null;
        }
        return new Factura(
                dto.getId(),
                reserva,
                dto.getFechaEmision(),
                dto.getTotal(),
                dto.getEstado(),
                dto.getDescripcion(),
                null
        );
    }

    public PagoDto toDto(Pago pago) {
        if (pago == null) {
            return null;
        }
        return new PagoDto(
                pago.getId(),
                pago.getFactura() == null ? null : pago.getFactura().getId(),
                pago.getFechaPago(),
                pago.getMonto(),
                pago.getMetodo(),
                pago.getEstado()
        );
    }

    public Pago toEntity(PagoDto dto, Factura factura) {
        if (dto == null) {
            return null;
        }
        return new Pago(
                dto.getId(),
                factura,
                dto.getFechaPago(),
                dto.getMonto(),
                dto.getMetodo(),
                dto.getEstado()
        );
    }

    public IngresoDto toDto(Ingreso ingreso) {
        if (ingreso == null) {
            return null;
        }
        return new IngresoDto(
                ingreso.getId(),
                ingreso.getDescripcion(),
                ingreso.getMonto(),
                ingreso.getFecha(),
                ingreso.getCategoria()
        );
    }

    public Ingreso toEntity(IngresoDto dto) {
        if (dto == null) {
            return null;
        }
        return new Ingreso(
                dto.getId(),
                dto.getDescripcion(),
                dto.getMonto(),
                dto.getFecha(),
                dto.getCategoria()
        );
    }

    public EgresoDto toDto(Egreso egreso) {
        if (egreso == null) {
            return null;
        }
        return new EgresoDto(
                egreso.getId(),
                egreso.getDescripcion(),
                egreso.getMonto(),
                egreso.getFecha(),
                egreso.getCategoria()
        );
    }

    public Egreso toEntity(EgresoDto dto) {
        if (dto == null) {
            return null;
        }
        return new Egreso(
                dto.getId(),
                dto.getDescripcion(),
                dto.getMonto(),
                dto.getFecha(),
                dto.getCategoria()
        );
    }
}
