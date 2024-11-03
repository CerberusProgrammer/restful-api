package com.example.restful_api.metodo_de_pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos-de-pago")
public class MetodoDePagoController {

    @Autowired
    private MetodoDePagoRepository metodoDePagoRepository;

    @PostMapping
    public MetodoDePago createMetodoDePago(@RequestBody MetodoDePago metodoDePago) {
        return metodoDePagoRepository.save(metodoDePago);
    }
}