package com.example.front.client;

import com.example.front.Entity.Persona;

import java.util.List;

public interface PersonsaClient {
    List<Persona> findAll();

    Persona save(Persona persona);
}
