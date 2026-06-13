<<<<<<< HEAD
package com.upiiz.listas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListasController
{
    //GET, POST, PUT, DELETE
    //http://localhost:8081/listas
    //http://127.0.0.1:8081/lists
    //http://192.168.137.102:8081/listas
    //http://listas.render.com/listas
    @GetMapping("/listas")
    public String mostrarlistas()
    {
        return "listas";
    }

}
=======
package com.upiiz.listas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListasController
{
    //GET, POST, PUT, DELETE
    //http://localhost:8081/listas
    //http://127.0.0.1:8081/lists
    //http://192.168.137.102:8081/listas
    //http://listas.render.com/listas
    @GetMapping("/listas")
    public String mostrarlistas()
    {
        return "listas";
    }

}
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
