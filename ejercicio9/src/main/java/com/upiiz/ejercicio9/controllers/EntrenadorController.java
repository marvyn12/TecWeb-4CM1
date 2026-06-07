package com.upiiz.ejercicio9.controllers;

import com.upiiz.ejercicio9.entities.EntrenadorEntity;
import com.upiiz.ejercicio9.services.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public String listarEntrenadores(Model model) {
        model.addAttribute("entrenadores", entrenadorService.obtenerTodos());
        return "listado-entrenadores";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("entrenador", new EntrenadorEntity());
        return "agregar-entrenador";
    }

    @PostMapping("/guardar")
    public String guardarEntrenador(@ModelAttribute EntrenadorEntity entrenador) {
        entrenadorService.guardar(entrenador);
        return "redirect:/entrenadores";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        model.addAttribute("entrenador", entrenadorService.obtenerPorId(id));
        return "actualizar-entrenador";
    }

    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioEliminar(@PathVariable Long id, Model model) {
        model.addAttribute("entrenador", entrenadorService.obtenerPorId(id));
        return "eliminar-entrenador";
    }

    @PostMapping("/borrar/{id}")
    public String borrarEntrenador(@PathVariable Long id) {
        entrenadorService.eliminar(id);
        return "redirect:/entrenadores";
    }
}