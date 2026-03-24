package com.ejercicio8.ejercicio8.controllers;

import com.ejercicio8.ejercicio8.models.Categoria;
import com.ejercicio8.ejercicio8.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.obtenerTodas());
        return "listado-categorias";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formulario-agregar-categoria";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaService.obtenerPorId(id));
        return "formulario-actualizar-categoria";
    }

    @PostMapping("/guardar-actualizacion")
    public String actualizarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.actualizarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioEliminar(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaService.obtenerPorId(id));
        return "formulario-eliminar-categoria";
    }

    @PostMapping("/borrar/{id}")
    public String borrarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}