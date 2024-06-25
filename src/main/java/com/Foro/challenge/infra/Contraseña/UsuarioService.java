package com.Foro.challenge.infra.Contraseña;

import com.Foro.challenge.repository.UsuarioRepository;
import com.Foro.challenge.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario crearUsuario(String username, String password) {
        String passwordHash = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, passwordHash);
        return usuarioRepository.save(usuario);
    }
}