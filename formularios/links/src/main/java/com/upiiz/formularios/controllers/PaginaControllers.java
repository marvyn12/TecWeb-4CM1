<<<<<<< HEAD
package com.upiiz.formularios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaControllers {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
=======
package com.upiiz.formularios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaControllers {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
