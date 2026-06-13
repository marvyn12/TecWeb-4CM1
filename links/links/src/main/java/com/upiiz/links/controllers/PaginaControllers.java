<<<<<<< HEAD
package com.upiiz.links.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaControllers {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/servicios")
    public String servicios(){
        return "servicios";
    }

    @GetMapping("/contactos")
    public String contactos(){
        return "contactos";
    }
}
=======
package com.upiiz.links.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaControllers {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/servicios")
    public String servicios(){
        return "servicios";
    }

    @GetMapping("/contactos")
    public String contactos(){
        return "contactos";
    }
}
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
