package com.ejercicio8.ejercicio8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/tienda"})
    public String index() {
        return "index";
    }
}