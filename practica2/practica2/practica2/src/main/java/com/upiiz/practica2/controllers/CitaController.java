package com.upiiz.practica2.controllers;

import com.upiiz.practica2.entities.Cita;
import com.upiiz.practica2.services.CitaService;
import com.upiiz.practica2.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private PacienteService pacienteService;


    @GetMapping
    public String listarCitas(Model model) {
        model.addAttribute("citas", citaService.obtenerTodas());
        return "citas/index";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrear(Model model) {
        model.addAttribute("cita", new Cita());

        model.addAttribute("pacientes", pacienteService.obtenerTodos());
        return "citas/create";
    }


    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute("cita") Cita cita) {
        citaService.guardar(cita);
        return "redirect:/citas";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
        Optional<Cita> cita = citaService.obtenerPorId(id);
        if (cita.isPresent()) {
            model.addAttribute("cita", cita.get());

            model.addAttribute("pacientes", pacienteService.obtenerTodos());
            return "citas/edit";
        }
        return "redirect:/citas";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarCita(@PathVariable Long id) {
        citaService.eliminar(id);
        return "redirect:/citas";
    }
}