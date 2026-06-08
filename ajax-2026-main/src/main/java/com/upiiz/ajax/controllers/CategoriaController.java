package com.upiiz.ajax.controllers;

import com.upiiz.ajax.entities.CategoriaEntity;
import com.upiiz.ajax.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias/api/categorias")
    @ResponseBody
    public ResponseEntity<List<CategoriaEntity>> listadoCategoriasAJAX() {
        return ResponseEntity.ok(categoriaService.listado());
    }
}