package com.example.pgdbapi.service;

import com.example.pgdbapi.model.Candidato;
import com.example.pgdbapi.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {
    @Autowired
    CandidatoRepository candidatoRepository;

    public List<Candidato> getAll() throws Exception {
        try {
            return candidatoRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
