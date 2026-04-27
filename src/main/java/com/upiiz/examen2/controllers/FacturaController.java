package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.repositories.VentaRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FacturaController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/facturacion/{id}")
    public String generarFactura(@PathVariable Long id, HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta == null) {
            return "redirect:/ventas";
        }
        model.addAttribute("venta", venta);
        return "facturacion/invoice";
    }
}