package com.ejercicio8.ejercicio8.controllers;

import com.ejercicio8.ejercicio8.models.Producto;
import com.ejercicio8.ejercicio8.services.CategoriaService;
import com.ejercicio8.ejercicio8.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.obtenerTodos());
        return "listado-productos";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.obtenerTodas());
        return "formulario-agregar-producto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.obtenerPorId(id));
        model.addAttribute("categorias", categoriaService.obtenerTodas());
        return "formulario-actualizar-producto";
    }

    @PostMapping("/guardar-actualizacion")
    public String actualizarProducto(@ModelAttribute Producto producto) {
        productoService.actualizarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioEliminar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.obtenerPorId(id));
        return "formulario-eliminar-producto";
    }

    @PostMapping("/borrar/{id}")
    public String borrarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }
}