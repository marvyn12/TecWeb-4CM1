<<<<<<< HEAD
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
=======
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
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
}