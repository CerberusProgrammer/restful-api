package com.example.restful_api.persona;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/personas")
public class PersonaController {

    private PersonaRepository personaRepository;

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @GetMapping
    public Iterable<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona not found"));
    }
}