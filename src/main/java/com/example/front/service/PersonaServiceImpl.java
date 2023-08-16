package com.example.front.service;

import com.example.front.Entity.Persona;
import com.example.front.client.impl.PersonaClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaClientImpl personaClient;

    @Override
    public List<Persona> findAll() {
        return personaClient.findAll();
    }

    @Override
    public Persona findById(Long id) {
        return personaClient.findById(id);
    }

    @Override
    public Persona create(Persona persona) {
        return personaClient.save(persona);
    }
}
