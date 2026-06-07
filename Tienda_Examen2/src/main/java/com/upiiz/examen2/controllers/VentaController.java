package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.DetalleVenta;
import com.upiiz.examen2.entities.Producto;
import com.upiiz.examen2.entities.Usuario;
import com.upiiz.examen2.entities.Venta;
import com.upiiz.examen2.repositories.ProductoRepository;
import com.upiiz.examen2.repositories.VentaRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        model.addAttribute("ventas", ventaRepository.findAll());
        return "ventas/index";
    }

    @GetMapping("/punto-venta")
    public String puntoVenta(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        if (session.getAttribute("carrito") == null) {
            session.setAttribute("carrito", new ArrayList<DetalleVenta>());
        }
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("carrito", session.getAttribute("carrito"));
        return "ventas/punto_venta";
    }

    @PostMapping("/agregar")
    public String agregarAlCarrito(@RequestParam Long productoId, @RequestParam Integer cantidad, HttpSession session) {
        List<DetalleVenta> carrito = (List<DetalleVenta>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        Producto producto = productoRepository.findById(productoId).orElse(null);
        if (producto != null && producto.getStock() >= cantidad) {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setCantidad(cantidad);
            detalle.setSubtotal(producto.getPrecio() * cantidad);
            carrito.add(detalle);
            session.setAttribute("carrito", carrito);
        }
        return "redirect:/ventas/punto-venta";
    }

    @GetMapping("/limpiar")
    public String limpiarCarrito(HttpSession session) {
        session.removeAttribute("carrito");
        return "redirect:/ventas/punto-venta";
    }

    @PostMapping("/procesar")
    public String procesarVenta(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        List<DetalleVenta> carrito = (List<DetalleVenta>) session.getAttribute("carrito");

        if (usuario != null && carrito != null && !carrito.isEmpty()) {
            Venta venta = new Venta();
            venta.setFecha(LocalDateTime.now());
            venta.setUsuario(usuario);

            double total = 0;
            for (DetalleVenta detalle : carrito) {
                detalle.setVenta(venta);
                total += detalle.getSubtotal();

                Producto p = detalle.getProducto();
                p.setStock(p.getStock() - detalle.getCantidad());
                productoRepository.save(p);
            }
            venta.setTotal(total);
            venta.setDetalles(carrito);

            ventaRepository.save(venta);
            session.removeAttribute("carrito");
        }
        return "redirect:/ventas";
    }
}