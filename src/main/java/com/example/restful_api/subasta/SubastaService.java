package com.example.restful_api.subasta;

import org.springframework.stereotype.Service;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.metodo_de_pago.MetodoDePagoRepository;
import com.example.restful_api.persona.Persona;
import com.example.restful_api.persona.PersonaRepository;
import com.example.restful_api.subasta.projections.SubastaDetailedProjection;
import com.example.restful_api.subasta.projections.SubastaSimpleProjection;
import com.example.restful_api.subasta.projections.SubastaMetodoDePagoProjection;
import com.example.restful_api.subasta.projections.SubastaPersonaProjection;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubastaService {

    private SubastaRepository subastaRepository;
    private PersonaRepository personaRepository;
    private MetodoDePagoRepository metodoDePagoRepository;

    public Object getSubasta(Long id, String projection) {
        switch (projection) {
            case "simple":
                return subastaRepository.findById(id, SubastaSimpleProjection.class);
            case "detailed":
                return subastaRepository.findById(id, SubastaDetailedProjection.class);
            case "metodoDePago":
                return subastaRepository.findById(id, SubastaMetodoDePagoProjection.class);
            case "persona":
                return subastaRepository.findById(id, SubastaPersonaProjection.class);
            default:
                return subastaRepository.findById(id, Subasta.class);
        }
    }

    public Subasta createSubasta(SubastaDTO subastaDTO) {
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