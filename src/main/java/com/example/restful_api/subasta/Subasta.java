package com.example.restful_api.subasta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

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

    @ManyToOne
    private MetodoDePago metodoDePago;
}
