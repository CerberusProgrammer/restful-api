package com.example.restful_api.subasta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

import com.example.restful_api.metodo_de_pago.MetodoDePago;
import com.example.restful_api.persona.Persona;

@Data
@Entity
@Table(name = "subasta")
public class Subasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToMany
    private List<Persona> participantes;

    @ManyToOne
    private MetodoDePago metodoDePago;
}
