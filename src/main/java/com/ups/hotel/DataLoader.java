package com.ups.hotel;

import com.ups.hotel.model.Cliente;
import com.ups.hotel.model.Habitacion;
import com.ups.hotel.model.Reserva;
import com.ups.hotel.repository.ClienteRepository;
import com.ups.hotel.repository.HabitacionRepository;
import com.ups.hotel.repository.ReservaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner seedData(ClienteRepository clienteRepository,
                                      HabitacionRepository habitacionRepository,
                                      ReservaRepository reservaRepository) {
        return args -> {
            if (clienteRepository.count() == 0) {
                Cliente cliente = new Cliente();
                cliente.setNombre("Juan Perez");
                cliente.setTelefono("555-0100");
                cliente.setEmail("juan.perez@example.com");
                clienteRepository.save(cliente);

                Habitacion habitacion = new Habitacion();
                habitacion.setNumero("101");
                habitacion.setTipo("Standard");
                habitacion.setPrecio(BigDecimal.valueOf(120.00));
                habitacion.setDisponible(true);
                habitacionRepository.save(habitacion);

                Reserva reserva = new Reserva();
                reserva.setCliente(cliente);
                reserva.setHabitacion(habitacion);
                reserva.setFechaIngreso(LocalDate.now().plusDays(1));
                reserva.setFechaSalida(LocalDate.now().plusDays(4));
                reserva.setEstado("CONFIRMADA");
                reservaRepository.save(reserva);
            }
        };
    }
}
