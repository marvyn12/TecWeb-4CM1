package com.ejercicio8.ejercicio8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Long id;
    private String nombre;
    private double precio;
    private String categoria;
}