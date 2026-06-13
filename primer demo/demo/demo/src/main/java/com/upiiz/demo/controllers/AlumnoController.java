<<<<<<< HEAD
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
=======
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
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
