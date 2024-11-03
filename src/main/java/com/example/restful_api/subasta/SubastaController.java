package com.example.restful_api.subasta;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubastaController {

    private SubastaService subastaService;

    /*
     * Opciones y filtros:
     * - simple: solo devuelve los datos de la subasta
     * - detailed: devuelve los datos de la subasta, la persona y el método de pago
     * - personaNombre: filtra las subastas por el nombre de la persona
     * - metodoDePagoTipo: filtra las subastas por el tipo de método de pago
     * 
     * Ejemplos:
     * - /subastas/1?projection=simple
     * - /subastas/1?projection=detailed
     * - /subastas?personaNombre=John&metodoDePagoTipo=credit
     * - /subastas?personaNombre=John
     * - /subastas?metodoDePagoTipo=credit
     * - /subastas
     * 
     */
    @GetMapping("/subastas/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Object getSubasta(@PathVariable Long id, @RequestParam(defaultValue = "simple") String projection) {
        return subastaService.getSubasta(id, projection);
    }

    /*
     * Opciones y filtros:
     * - personaNombre: filtra las subastas por el nombre de la persona
     * - metodoDePagoTipo: filtra las subastas por el tipo de método de pago
     * 
     * Ejemplos:
     * - /subastas?personaNombre=John&metodoDePagoTipo=credit
     * - /subastas?personaNombre=John
     * - /subastas?metodoDePagoTipo=credit
     * - /subastas
     * 
     */
    @GetMapping("/subastas")
    @ResponseStatus(code = HttpStatus.OK)
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public Subasta createSubasta(@RequestBody SubastaDTO subastaDTO) {
        return subastaService.createSubasta(subastaDTO);
    }

    @PutMapping("/subastas/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Subasta updateSubasta(@PathVariable Long id, @RequestBody SubastaDTO subastaDTO) {
        return subastaService.updateSubasta(id, subastaDTO);
    }

    @DeleteMapping("/subastas/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSubasta(@PathVariable Long id) {
        subastaService.deleteSubasta(id);
    }
}