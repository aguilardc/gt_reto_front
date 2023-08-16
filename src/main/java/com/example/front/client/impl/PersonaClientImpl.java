package com.example.front.client.impl;

import com.example.front.Entity.Persona;
import com.example.front.client.PersonsaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonaClientImpl implements PersonsaClient {

    protected RestTemplate restTemplate;

    @Override
    public List<Persona> findAll() {
        restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/personas";
        ResponseEntity<?> responseList = restTemplate.getForEntity(url, Persona[].class);
        Persona[] personas = (Persona[]) responseList.getBody();
        return Arrays.asList(personas);
    }

    public Persona findById(Long id) {
        restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/personas/"  + id;
        ResponseEntity<?> personaResponse = restTemplate.getForEntity(url, Persona.class);
        return (Persona) personaResponse.getBody();
    }

    @Override
    public Persona save(Persona persona) {
        restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/personas";
        ResponseEntity<?> personaResponse = restTemplate.postForEntity(url, persona, Persona.class);
        return (Persona) personaResponse.getBody();
    }
}
