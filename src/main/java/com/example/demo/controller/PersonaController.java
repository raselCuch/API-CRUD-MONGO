package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/Persona")
public class PersonaController {

    @Autowired
    private PersonaRepository repositorio;

    @PostMapping // localhost:8080/Persona
    public ResponseEntity<?> savePersona(@RequestBody Persona persona) {
        try {
            Persona personaSave = repositorio.save(persona);
            return new ResponseEntity<Persona>(personaSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> findPersona() {
        try {
            List<Persona> personaAll = repositorio.findAll();
            return new ResponseEntity<List<Persona>>(personaAll, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePersona(@RequestBody Persona persona) {
        try {
            Persona personaSave = repositorio.save(persona);
            return new ResponseEntity<Persona>(personaSave, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")// localhost:8080/Persona/0
    public ResponseEntity<?> deletePersona(@PathVariable("id") Integer id) {
        try {
            // Persona personaSave = 
            repositorio.deleteById(id);
            return new ResponseEntity<String>("Fué eliminado", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
