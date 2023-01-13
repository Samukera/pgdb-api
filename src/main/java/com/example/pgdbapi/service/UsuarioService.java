package com.example.pgdbapi.service;

import com.example.pgdbapi.dto.UsuarioDto;
import com.example.pgdbapi.model.Usuario;
import com.example.pgdbapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();

    @Transactional
    public Usuario createUser(Usuario usuario) throws Exception {
        try {
            usuario.setSenha(passEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public UsuarioDto getById(Long id) throws Exception{
        try {
            return usuarioRepository.findById(id).get().toUsuarioDto();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
