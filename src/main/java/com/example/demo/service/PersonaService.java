package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

// import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

public class PersonaService {
    @Autowired
    PersonaRepository repository;

    // @Override
    // public void create(Persona obj) {
    //     repository.save(obj);
    // }

}
