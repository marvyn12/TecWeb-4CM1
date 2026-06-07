package com.upiiz.ejercicio9.controllers;

import com.upiiz.ejercicio9.entities.JugadorEntity;
import com.upiiz.ejercicio9.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorService.obtenerTodos());
        return "listado-jugadores";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("jugador", new JugadorEntity());
        return "agregar-jugador";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute JugadorEntity jugador) {
        jugadorService.guardar(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        model.addAttribute("jugador", jugadorService.obtenerPorId(id));
        return "actualizar-jugador";
    }

    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioEliminar(@PathVariable Long id, Model model) {
        model.addAttribute("jugador", jugadorService.obtenerPorId(id));
        return "eliminar-jugador";
    }

    @PostMapping("/borrar/{id}")
    public String borrarJugador(@PathVariable Long id) {
        jugadorService.eliminar(id);
        return "redirect:/jugadores";
    }
}