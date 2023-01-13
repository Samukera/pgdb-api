package com.example.pgdbapi.controller;

import com.example.pgdbapi.dto.UsuarioDto;
import com.example.pgdbapi.model.Usuario;
import com.example.pgdbapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDto> createUser(@Valid @RequestBody Usuario usuario, UriComponentsBuilder uriBuilder) throws Exception {
        try {
            UsuarioDto u = usuarioService.createUser(usuario).toUsuarioDto();
            URI uri = uriBuilder.path("usuario/{id}").buildAndExpand(u.getId()).toUri();
            return ResponseEntity.created(uri).body(u);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUserById(@PathVariable Long id) throws Exception {
        try {
            UsuarioDto u = usuarioService.getById(id);
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
