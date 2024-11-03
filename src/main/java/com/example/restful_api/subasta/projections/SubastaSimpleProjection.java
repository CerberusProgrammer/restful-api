package com.example.restful_api.subasta.projections;

import org.springframework.data.rest.core.config.Projection;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.persona.Persona;
import com.example.restful_api.subasta.Subasta;

/**
 * Proyección simple de la entidad Subasta.
 * Esta proyección incluye los identificadores de la subasta, persona y método
 * de pago.
 * 
 * @Projection(name = "simple", types = { Subasta.class })
 */
@Projection(name = "simple", types = { Subasta.class })
public interface SubastaSimpleProjection {
    Long getId();

    @Projection(name = "personaId", types = { Persona.class })
    interface PersonaIdProjection {
        Long getId();
    }

    @Projection(name = "metodoDePagoId", types = { MetodoDePago.class })
    interface MetodoDePagoIdProjection {
        Long getId();
    }

    PersonaIdProjection getPersona();

    MetodoDePagoIdProjection getMetodoDePago();
}