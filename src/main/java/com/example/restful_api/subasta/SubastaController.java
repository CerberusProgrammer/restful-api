package com.example.restful_api.subasta;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubastaController {

    private SubastaService subastaService;

    @GetMapping("/subastas/{id}")
    public Object getSubasta(@PathVariable Long id, @RequestParam(defaultValue = "simple") String projection) {
        return subastaService.getSubasta(id, projection);
    }

    @GetMapping("/subastas")
    public List<?> getAllSubastas(
            @RequestParam(required = false) String personaNombre,
            @RequestParam(required = false) String metodoDePagoTipo,
            @RequestParam(defaultValue = "simple") String projection) {
        SubastaFilter filter = new SubastaFilter();
        filter.setPersonaNombre(personaNombre);
        filter.setMetodoDePagoTipo(metodoDePagoTipo);
        return subastaService.getAllSubastas(filter, projection);
    }

    @PostMapping("/subastas")
    public Subasta createSubasta(@RequestBody SubastaDTO subastaDTO) {
        return subastaService.createSubasta(subastaDTO);
    }
}