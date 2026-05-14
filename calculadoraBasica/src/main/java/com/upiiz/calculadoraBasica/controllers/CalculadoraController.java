package com.upiiz.calculadoraBasica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculadoraController {

    @GetMapping("/")
    public String index() {
        // Esto le dice que al entrar a la raíz, muestre directo tu calculadora.html
        return "calculadora";
    }
}