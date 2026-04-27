package com.upiiz.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {

    //Get - Regrese un recurso del servidor
    // cualquier solicitud que se realice del lado del servidor -GET
    //Metodos para contestar a los clientes por el metodo - GET


    //Metodos que muestre el listado  de Alumnos

    @GetMapping("/profesores/grupo/listado-alumnos")
    public String getALLALUMNOS (){

        return "Lista de Alumnos";

    }


}
