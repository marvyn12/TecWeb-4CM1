package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.Producto;
import com.upiiz.examen2.entities.Usuario;
import com.upiiz.examen2.repositories.ProductoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    private boolean esAdmin(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        return usuario != null && "ADMIN".equals(usuario.getRol());
    }

    @GetMapping
    public String index(HttpSession session, Model model) {
        if (!esAdmin(session)) return "redirect:/";
        model.addAttribute("productos", productoRepository.findAll());
        return "productos/index";
    }

    @GetMapping("/nuevo")
    public String create(HttpSession session, Model model) {
        if (!esAdmin(session)) return "redirect:/";
        model.addAttribute("producto", new Producto());
        return "productos/form";
    }

    @PostMapping("/guardar")
    public String save(Producto producto, HttpSession session) {
        if (!esAdmin(session)) return "redirect:/";
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, HttpSession session, Model model) {
        if (!esAdmin(session)) return "redirect:/";
        Producto producto = productoRepository.findById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "productos/form";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        if (!esAdmin(session)) return "redirect:/";
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }
}