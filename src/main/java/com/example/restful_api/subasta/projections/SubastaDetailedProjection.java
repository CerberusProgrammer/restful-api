package com.example.restful_api.subasta.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.persona.Persona;
import com.example.restful_api.subasta.Subasta;

@Projection(name = "detailed", types = { Subasta.class })
public interface SubastaDetailedProjection {
    Long getId();

    Persona getPersona();

    MetodoDePago getMetodoDePago();
}