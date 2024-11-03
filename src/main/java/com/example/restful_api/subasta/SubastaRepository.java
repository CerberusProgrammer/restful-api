package com.example.restful_api.subasta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SubastaRepository extends JpaRepository<Subasta, Long> {
    <T> T findById(@Param("id") Long id, Class<T> type);

    <T> List<T> findAllBy(Class<T> type);
}