package com.example.restful_api.metodo_de_pago;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/metodos-de-pago")
public class MetodoDePagoController {

    private MetodoDePagoRepository metodoDePagoRepository;

    @PostMapping
    public MetodoDePago createMetodoDePago(@RequestBody MetodoDePago metodoDePago) {
        return metodoDePagoRepository.save(metodoDePago);
    }
}