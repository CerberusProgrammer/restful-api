package com.example.restful_api.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "personas", path = "personas")
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}