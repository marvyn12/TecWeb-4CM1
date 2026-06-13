package com.upiiz.tienda_mascotas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer edad;
    private String raza;
    private String observaciones;
}