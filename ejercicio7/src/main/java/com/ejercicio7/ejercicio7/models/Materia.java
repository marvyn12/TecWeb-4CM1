package com.ejercicio7.ejercicio7.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
    private Long id;
    private String nombre;
    private int creditos;
}