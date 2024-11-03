package com.example.restful_api.subasta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.persona.Persona;
import com.example.restful_api.subasta.Subasta;
import com.example.restful_api.subasta.SubastaFilter;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("customSubastaRepository")
public class SubastaRepositoryCustomImpl implements SubastaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Subasta> findByCriteria(SubastaFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subasta> query = cb.createQuery(Subasta.class);
        Root<Subasta> subasta = query.from(Subasta.class);
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getPersonaNombre() != null) {
            Join<Subasta, Persona> personaJoin = subasta.join("persona");
            predicates.add(cb.like(personaJoin.get("nombre"), "%" + filter.getPersonaNombre() + "%"));
        }

        if (filter.getMetodoDePagoTipo() != null) {
            Join<Subasta, MetodoDePago> metodoDePagoJoin = subasta.join("metodoDePago");
            predicates.add(cb.like(metodoDePagoJoin.get("tipo"), "%" + filter.getMetodoDePagoTipo() + "%"));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}