package com.example.restful_api.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "direcciones", path = "direcciones")
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
