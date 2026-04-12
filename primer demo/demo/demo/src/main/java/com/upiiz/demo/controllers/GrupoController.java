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
