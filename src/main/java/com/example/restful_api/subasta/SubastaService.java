package com.example.restful_api.subasta;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.metodo_de_pago.MetodoDePagoRepository;
import com.example.restful_api.persona.Persona;
import com.example.restful_api.persona.PersonaRepository;
import com.example.restful_api.subasta.projections.SubastaDetailedProjection;
import com.example.restful_api.subasta.projections.SubastaSimpleProjection;
import com.example.restful_api.subasta.repository.SubastaRepository;
import com.example.restful_api.subasta.repository.SubastaRepositoryCustom;
import com.example.restful_api.subasta.projections.SubastaMetodoDePagoProjection;
import com.example.restful_api.subasta.projections.SubastaPersonaProjection;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubastaService {

    private SubastaRepository subastaRepository;
    private PersonaRepository personaRepository;
    private MetodoDePagoRepository metodoDePagoRepository;

    @Qualifier("customSubastaRepository")
    private SubastaRepositoryCustom subastaRepositoryCustom;

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

    public List<?> getAllSubastas(SubastaFilter filter, String projection) {
        List<Subasta> subastas = subastaRepositoryCustom.findByCriteria(filter);
        switch (projection) {
            case "simple":
                return subastas.stream()
                        .map(subasta -> subastaRepository.findById(subasta.getId(), SubastaSimpleProjection.class))
                        .collect(Collectors.toList());
            case "detailed":
                return subastas.stream()
                        .map(subasta -> subastaRepository.findById(subasta.getId(), SubastaDetailedProjection.class))
                        .collect(Collectors.toList());
            case "metodoDePago":
                return subastas.stream()
                        .map(subasta -> subastaRepository.findById(subasta.getId(),
                                SubastaMetodoDePagoProjection.class))
                        .collect(Collectors.toList());
            case "persona":
                return subastas.stream()
                        .map(subasta -> subastaRepository.findById(subasta.getId(), SubastaPersonaProjection.class))
                        .collect(Collectors.toList());
            default:
                return subastas;
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