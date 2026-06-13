<<<<<<< HEAD
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
=======
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
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
}