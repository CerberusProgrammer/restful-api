package com.example.restful_api.user;

import com.example.restful_api.empleado.Empleado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "password", nullable = true)
    private String password;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Empleado empleado;
}