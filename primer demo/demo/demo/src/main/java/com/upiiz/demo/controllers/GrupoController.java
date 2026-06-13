<<<<<<< HEAD
package com.upiiz.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrupoController {
    //creamos un metodo para que nos regrese todos los alumnos
    //GET
    @GetMapping("/Profesores/grupos/listado")
    public String getALLAGrupos(){

        return "Grupos Asignados";

    }
}
=======
package com.upiiz.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrupoController {
    //creamos un metodo para que nos regrese todos los alumnos
    //GET
    @GetMapping("/Profesores/grupos/listado")
    public String getALLAGrupos(){

        return "Grupos Asignados";

    }
}
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
