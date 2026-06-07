package com.upiiz.examen1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redireccionarInicio() {
        return "redirect:/departamentos";
    }
}