package com.example.pgdbapi.controller;

import com.example.pgdbapi.model.Boletim;
import com.example.pgdbapi.service.BoletimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boletim")
public class BoletimController {
    @Autowired
    BoletimService boletimService;

    @GetMapping("/all")
    public ResponseEntity<List<Boletim>> getAll() throws Exception {
        try {
            List<Boletim> boletims = boletimService.getAll();
            return ResponseEntity.ok().body(boletims);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveBoletim(@RequestBody Boletim boletim, UriComponentsBuilder uriBuilder) throws Exception {
        try {
            String bo = boletimService.saveBoletim(boletim);
            return ResponseEntity.ok().body(bo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boletim> getById(@PathVariable Long id) throws Exception {
        try {
            Optional<Boletim> boletim = boletimService.getById(id);
            if (boletim.isPresent()) {
                return ResponseEntity.ok().body(boletim.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
