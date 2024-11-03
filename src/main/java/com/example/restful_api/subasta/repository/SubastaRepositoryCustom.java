package com.example.restful_api.subasta.repository;

import java.util.List;

import com.example.restful_api.subasta.Subasta;
import com.example.restful_api.subasta.SubastaFilter;

public interface SubastaRepositoryCustom {
    List<Subasta> findByCriteria(SubastaFilter filter);
}