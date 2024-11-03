package com.example.restful_api.subasta.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.persona.Persona;
import com.example.restful_api.subasta.Subasta;

@Projection(name = "persona", types = { Subasta.class })
public interface SubastaPersonaProjection {
    Long getId();

    Persona getPersona();

    @Projection(name = "metodoDePagoId", types = { MetodoDePago.class })
    interface MetodoDePagoIdProjection {
        Long getId();
    }

    MetodoDePagoIdProjection getMetodoDePago();
}