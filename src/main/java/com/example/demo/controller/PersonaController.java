package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/Persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @PostMapping // localhost:8080/Persona
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
        try {
            Persona personaSave = personaService.guardarPersona(persona);
            return new ResponseEntity<>(personaSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> findPersona() {
        try {
            ArrayList<Persona> personaAll = personaService.obtenerPersonas();
            // logger.info("Numero de usuarios recuperados: {}", personaAll.size());
            return new ResponseEntity<>(personaAll, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(MensajesParametrizados.MENSAJE_ERROR_INTERNO_SERVIDOR, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
        try {
            Persona personaSave = personaService.actualizarPersona(persona);
            return new ResponseEntity<>(personaSave, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}") // localhost:8080/Persona/0
    public ResponseEntity<String> deletePersona(@PathVariable("id") Integer id) {
        try {
            personaService.eliminarPersona(id);
            return new ResponseEntity<>("Fue eliminado", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
