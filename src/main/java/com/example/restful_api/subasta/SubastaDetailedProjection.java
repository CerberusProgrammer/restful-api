package com.example.restful_api.subasta;

import org.springframework.data.rest.core.config.Projection;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.persona.Persona;

@Projection(name = "detailed", types = { Subasta.class })
public interface SubastaDetailedProjection {
    Long getId();

    Persona getPersona();

    MetodoDePago getMetodoDePago();
}