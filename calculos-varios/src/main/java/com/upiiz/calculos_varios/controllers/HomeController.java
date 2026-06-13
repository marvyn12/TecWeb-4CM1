package com.upiiz.calculos_varios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        // Carga directo el archivo calculos.html
        return "calculos";
    }
}