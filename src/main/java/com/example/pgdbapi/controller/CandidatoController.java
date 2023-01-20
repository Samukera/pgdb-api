package com.example.pgdbapi.controller;

import com.example.pgdbapi.dto.UsuarioDto;
import com.example.pgdbapi.model.Candidato;
import com.example.pgdbapi.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
    @Autowired
    CandidatoService candidatoService;

    @GetMapping("/all")
    public ResponseEntity<List<Candidato>> getAll() throws Exception {
        try {
            List<Candidato> candidatos = candidatoService.getAll();
            return ResponseEntity.ok().body(candidatos);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Candidato> getCandidatoById(@PathVariable Long id) throws Exception {
        try {
            Candidato u = candidatoService.getById(id);
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
