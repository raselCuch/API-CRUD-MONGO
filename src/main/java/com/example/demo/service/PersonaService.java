package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository repository;

    public ArrayList<Persona> obtenerPersonas() {// obten All usuarios
        return (ArrayList<Persona>) repository.findAll();
    }

    public Persona guardarPersona(Persona persona) {
        return repository.save(persona);
    }

    public Persona actualizarPersona(Persona persona) {
        return repository.save(persona);
    }

    public void eliminarPersona(Integer id) {
        repository.deleteById(id);
    }
}
