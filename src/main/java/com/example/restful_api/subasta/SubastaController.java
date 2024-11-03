package com.example.restful_api.subasta;

import org.springframework.web.bind.annotation.*;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.metodo_de_pago.MetodoDePagoRepository;
import com.example.restful_api.persona.Persona;
import com.example.restful_api.persona.PersonaRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SubastaController {

    private SubastaRepository subastaRepository;

    private PersonaRepository personaRepository;

    private MetodoDePagoRepository metodoDePagoRepository;

    @GetMapping("/subastas/{id}")
    public Object getSubasta(@PathVariable Long id, @RequestParam String projection) {
        if ("simple".equals(projection)) {
            return subastaRepository.findById(id, SubastaSimpleProjection.class);
        } else if ("detailed".equals(projection)) {
            return subastaRepository.findById(id, SubastaDetailedProjection.class);
        } else {
            return subastaRepository.findById(id, Subasta.class);
        }
    }

    @PostMapping("/subastas")
    public Subasta createSubasta(@RequestBody SubastaDTO subastaDTO) {
        Persona persona = personaRepository.findById(subastaDTO.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona not found"));
        MetodoDePago metodoDePago = metodoDePagoRepository.findById(subastaDTO.getMetodoDePagoId())
                .orElseThrow(() -> new RuntimeException("MetodoDePago not found"));

        Subasta subasta = new Subasta();
        subasta.setPersona(persona);
        subasta.setMetodoDePago(metodoDePago);

        return subastaRepository.save(subasta);
    }
}