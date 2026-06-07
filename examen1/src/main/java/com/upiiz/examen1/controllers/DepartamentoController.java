package com.upiiz.examen1.controllers;

import com.upiiz.examen1.models.Departamento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    private List<Departamento> listaDepartamentos = new ArrayList<>();

    public DepartamentoController() {
        listaDepartamentos.add(new Departamento(1, "Recursos Humanos", "Edificio A", "555-0001"));
        listaDepartamentos.add(new Departamento(2, "Tecnología", "Edificio B", "555-0002"));
        listaDepartamentos.add(new Departamento(3, "Finanzas", "Edificio A", "555-0003"));
        listaDepartamentos.add(new Departamento(4, "Ventas", "Edificio C", "555-0004"));
        listaDepartamentos.add(new Departamento(5, "Marketing", "Edificio C", "555-0005"));
        listaDepartamentos.add(new Departamento(6, "Logística", "Planta Baja", "555-0006"));
        listaDepartamentos.add(new Departamento(7, "Soporte Técnico", "Edificio B", "555-0007"));
        listaDepartamentos.add(new Departamento(8, "Dirección General", "Penthouse", "555-0008"));
        listaDepartamentos.add(new Departamento(9, "Mantenimiento", "Sótano 1", "555-0009"));
        listaDepartamentos.add(new Departamento(10, "Legal", "Edificio A", "555-0010"));
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("departamentos", listaDepartamentos);
        return "lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "crear";
    }

    @PostMapping("/nuevo")
    public String guardar(@ModelAttribute Departamento departamento) {
        listaDepartamentos.add(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Departamento depto = listaDepartamentos.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst().orElse(null);
        model.addAttribute("departamento", depto);
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Departamento departamento) {
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            if (listaDepartamentos.get(i).getId().equals(id)) {
                listaDepartamentos.set(i, departamento);
                break;
            }
        }
        return "redirect:/departamentos";
    }

    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioEliminar(@PathVariable Integer id, Model model) {
        Departamento depto = listaDepartamentos.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst().orElse(null);
        model.addAttribute("departamento", depto);
        return "eliminar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        listaDepartamentos.removeIf(d -> d.getId().equals(id));
        return "redirect:/departamentos";
    }
}