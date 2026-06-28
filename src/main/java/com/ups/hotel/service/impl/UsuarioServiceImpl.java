package com.ups.hotel.service.impl;

import com.ups.hotel.entity.Usuario;
import com.ups.hotel.exception.ResourceNotFoundException;
import com.ups.hotel.repository.UsuarioRepository;
import com.ups.hotel.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Usuario existing = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        existing.setNombre(usuario.getNombre());
        existing.setUsername(usuario.getUsername());
        existing.setPassword(usuario.getPassword());
        existing.setEmail(usuario.getEmail());
        existing.setRol(usuario.getRol());
        return usuarioRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        Usuario existing = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        usuarioRepository.delete(existing);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
