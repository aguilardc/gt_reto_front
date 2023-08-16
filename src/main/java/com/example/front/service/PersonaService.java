package com.example.front.service;

import com.example.front.Entity.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> findAll();

    Persona findById(Long id);

    Persona create(Persona persona);
}
