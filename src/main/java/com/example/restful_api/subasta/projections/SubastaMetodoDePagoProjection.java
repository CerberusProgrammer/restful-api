package com.example.restful_api.subasta.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.subasta.Subasta;

@Projection(name = "metodoDePago", types = { Subasta.class })
public interface SubastaMetodoDePagoProjection {
    Long getId();

    MetodoDePago getMetodoDePago();

    @Projection(name = "personaId", types = { Subasta.class })
    interface PersonaIdProjection {
        Long getId();
    }

    PersonaIdProjection getPersona();
}