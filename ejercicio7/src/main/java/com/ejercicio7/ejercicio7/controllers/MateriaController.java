package com.ejercicio7.ejercicio7.controllers;

import com.ejercicio7.ejercicio7.dto.MateriaDTO;
import com.ejercicio7.ejercicio7.models.Materia;
import com.ejercicio7.ejercicio7.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public String listarMaterias(Model model) {
        List<Materia> materias = materiaService.obtenerTodas();
        List<MateriaDTO> materiasDTO = materias.stream()
                .map(m -> new MateriaDTO(m.getId(), m.getNombre(), m.getCreditos()))
                .collect(Collectors.toList());

        model.addAttribute("materias", materiasDTO);
        return "listado";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("materia", new MateriaDTO());
        return "formulario-crear";
    }

    @PostMapping("/guardar")
    public String guardarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO) {
        Materia materia = new Materia(materiaDTO.getId(), materiaDTO.getNombre(), materiaDTO.getCreditos());
        materiaService.guardarMateria(materia);
        return "redirect:/materias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Materia materia = materiaService.obtenerPorId(id);
        if (materia != null) {
            MateriaDTO materiaDTO = new MateriaDTO(materia.getId(), materia.getNombre(), materia.getCreditos());
            model.addAttribute("materia", materiaDTO);
            return "formulario-actualizar";
        }
        return "redirect:/materias";
    }

    @PostMapping("/actualizar")
    public String actualizarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO) {
        Materia materia = new Materia(materiaDTO.getId(), materiaDTO.getNombre(), materiaDTO.getCreditos());
        materiaService.actualizarMateria(materia);
        return "redirect:/materias";
    }

    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioEliminar(@PathVariable Long id, Model model) {
        Materia materia = materiaService.obtenerPorId(id);
        if (materia != null) {
            MateriaDTO materiaDTO = new MateriaDTO(materia.getId(), materia.getNombre(), materia.getCreditos());
            model.addAttribute("materia", materiaDTO);
            return "formulario-eliminiar";
        }
        return "redirect:/materias";
    }

    @PostMapping("/borrar/{id}")
    public String borrarMateria(@PathVariable Long id) {
        materiaService.eliminarMateria(id);
        return "redirect:/materias";
    }
}