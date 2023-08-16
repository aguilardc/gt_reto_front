package com.example.front.controller;

import com.example.front.Entity.Persona;
import com.example.front.dto.PersonaDTO;
import com.example.front.mapper.PersonaMapper;
import com.example.front.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonaController {

    @Autowired
    protected PersonaServiceImpl personaService;

    @Autowired
    protected PersonaMapper personaMapper;

    @GetMapping("/")
    public String findAll(Model model) {
        List<Persona> personaList = personaService.findAll();
        List<PersonaDTO> list = personaMapper.toDTOList(personaList);
        model.addAttribute("personas", list);
        return "personas";
    }

    @GetMapping("/nuevo")
    public String nuevo(Persona persona, Model model) {
        model.addAttribute("persona", persona);
        return "formulario";
    }

    @PostMapping("/persona/grabar")
    public String create(@ModelAttribute("persona") Persona persona) {
        personaService.create(persona);
        return "redirect:/";
    }

    @GetMapping("modificar/{id}")
    public String modificar(@PathVariable("id") Long id, Model model) {
        Persona persona = personaService.findById(id);
        model.addAttribute("persona", persona);
        return "formulario";
    }
}
