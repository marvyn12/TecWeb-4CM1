package com.upiiz.ejercicio9.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/fifa"})
    public String index() {
        return "index";
    }
}