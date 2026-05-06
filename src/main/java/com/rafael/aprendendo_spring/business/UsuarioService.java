package com.rafael.aprendendo_spring.business;

import com.rafael.aprendendo_spring.infrastructure.entity.Usuario;
import com.rafael.aprendendo_spring.infrastructure.exceptions.ConflictExceptions;
import com.rafael.aprendendo_spring.infrastructure.exceptions.ResourceNotFoundException;
import com.rafael.aprendendo_spring.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        verificarSeEmailJaExiste(usuario.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    private void verificarSeEmailJaExiste(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new ConflictExceptions("Este e-mail já está cadastrado: " + email);
        }
    }

    public boolean verificarEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscarUsuarioPorEmail (String email){
        return usuarioRepository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Email não encontrado " + email));
    }

    public void deletarUsuarioPorEmail (String email){
        usuarioRepository.deleteByEmail(email);
    }
}