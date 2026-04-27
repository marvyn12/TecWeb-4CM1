package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.Producto;
import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.repositories.ProductoRepository;
import com.upiiz.examen2.repositories.VentaRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        List<Producto> productos = productoRepository.findAll();
        List<String> nombresProductos = productos.stream().map(Producto::getNombre).collect(Collectors.toList());
        List<Integer> stockProductos = productos.stream().map(Producto::getStock).collect(Collectors.toList());

        List<Venta> ventas = ventaRepository.findAll();
        List<String> fechasVentas = ventas.stream().map(v -> v.getFecha().toString().substring(0, 10)).collect(Collectors.toList());
        List<Double> totalesVentas = ventas.stream().map(Venta::getTotal).collect(Collectors.toList());

        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("totalVentas", ventas.size());
        model.addAttribute("nombresProductos", nombresProductos);
        model.addAttribute("stockProductos", stockProductos);
        model.addAttribute("fechasVentas", fechasVentas);
        model.addAttribute("totalesVentas", totalesVentas);

        return "home/index";
    }
}