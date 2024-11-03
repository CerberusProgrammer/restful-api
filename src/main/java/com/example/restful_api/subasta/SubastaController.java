package com.example.restful_api.subasta;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SubastaController {

    private SubastaService subastaService;

    @GetMapping("/subastas/{id}")
    public Object getSubasta(@PathVariable Long id, @RequestParam(defaultValue = "simple") String projection) {
        return subastaService.getSubasta(id, projection);
    }

    @PostMapping("/subastas")
    public Subasta createSubasta(@RequestBody SubastaDTO subastaDTO) {
        return subastaService.createSubasta(subastaDTO);
    }
}