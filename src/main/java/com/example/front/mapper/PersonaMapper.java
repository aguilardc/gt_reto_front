package com.example.front.mapper;

import com.example.front.Entity.Persona;
import com.example.front.dto.PersonaDTO;
//import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonaMapper {

    public PersonaDTO toDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setFullName(persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        return personaDTO;
    }

    public List<PersonaDTO> toDTOList(List<Persona> personaList) {
        return personaList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Persona toEntity(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        return persona;
    }


}
