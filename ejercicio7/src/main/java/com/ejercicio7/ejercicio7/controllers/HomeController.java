<<<<<<< HEAD
package com.ejercicio7.ejercicio7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "redirect:/materias";
    }
=======
package com.ejercicio7.ejercicio7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "redirect:/materias";
    }
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
}