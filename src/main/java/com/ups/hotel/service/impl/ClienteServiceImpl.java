package com.ups.hotel.service.impl;

import com.ups.hotel.entity.Cliente;
import com.ups.hotel.exception.ResourceNotFoundException;
import com.ups.hotel.repository.ClienteRepository;
import com.ups.hotel.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        Cliente existing = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
        existing.setNombre(cliente.getNombre());
        existing.setTelefono(cliente.getTelefono());
        existing.setEmail(cliente.getEmail());
        existing.setDocumento(cliente.getDocumento());
        existing.setDireccion(cliente.getDireccion());
        return clienteRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        Cliente existing = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
        clienteRepository.delete(existing);
    }
}
