package com.upiiz.ejercicio10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Esto redirige la raíz directo a tu pantalla de inicio de sesión
        return "redirect:/auth/login";
    }
}
