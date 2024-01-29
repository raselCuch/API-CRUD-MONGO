package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(collection = "Persona")
public class Persona {
    @Id
    private int id;
    private String nombre;
    private String direcion;
    private String telefono;

}
