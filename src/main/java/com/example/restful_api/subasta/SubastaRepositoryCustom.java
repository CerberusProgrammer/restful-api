package com.example.restful_api.subasta;

import java.util.List;

public interface SubastaRepositoryCustom {
    List<Subasta> findByCriteria(SubastaFilter filter);
}