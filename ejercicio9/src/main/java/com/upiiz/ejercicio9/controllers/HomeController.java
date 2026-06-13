<<<<<<< HEAD
package com.upiiz.ejercicio9.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/fifa"})
    public String index() {
        return "index";
    }
=======
package com.upiiz.ejercicio9.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/fifa"})
    public String index() {
        return "index";
    }
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
}