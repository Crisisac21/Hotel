package com.ups.hotel.service;

import com.ups.hotel.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    Usuario update(Long id, Usuario usuario);
    void deleteById(Long id);
    Optional<Usuario> findByUsername(String username);
}
