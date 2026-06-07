package com.upiiz.practica2.controllers;

import com.upiiz.practica2.entities.Paciente;
import com.upiiz.practica2.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // 1. Mostrar el Listado (Tabla principal)
    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.obtenerTodos());
        return "pacientes/index"; // Va a buscar el archivo templates/pacientes/index.html
    }

    // 2. Mostrar el formulario para Agregar
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrear(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/create";
    }

    // 3. Guardar el nuevo registro y redireccionar a la tabla
    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        pacienteService.guardar(paciente);
        return "redirect:/pacientes";
    }

    // 4. Mostrar el formulario para Editar con los datos cargados
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
        Optional<Paciente> paciente = pacienteService.obtenerPorId(id);
        if (paciente.isPresent()) {
            model.addAttribute("paciente", paciente.get());
            return "pacientes/edit";
        }
        return "redirect:/pacientes";
    }

    // 5. Eliminar un registro y redireccionar
    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminar(id);
        return "redirect:/pacientes";
    }
}