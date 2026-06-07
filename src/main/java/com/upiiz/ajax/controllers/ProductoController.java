package com.upiiz.ajax.controllers;

import com.upiiz.ajax.entities.ProductoEntity;
import com.upiiz.ajax.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }

    @GetMapping("/productos/api/productos")
    @ResponseBody
    public ResponseEntity<List<ProductoEntity>> listadoProductosAJAX() {
        return ResponseEntity.ok(productoService.listado());
    }

    @GetMapping("/productos/api/productos/{id}")
    @ResponseBody
    public ResponseEntity<Optional<ProductoEntity>> productoByIdAJAX(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.productoPorId(id));
    }

    @PostMapping("/productos/api/productos")
    @ResponseBody
    public ResponseEntity<ProductoEntity> crearProductosAJAX(@RequestBody ProductoEntity producto) {
        return ResponseEntity.ok(productoService.agregarProducto(producto));
    }

    @PatchMapping("/productos/api/productos/{id}")
    @ResponseBody
    public ResponseEntity<ProductoEntity> actualizarProductoAJAX(@PathVariable Long id, @RequestBody ProductoEntity producto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
    }

    @DeleteMapping("/productos/api/productos/{id}")
    @ResponseBody
    public ResponseEntity<Void> eliminarProductoAJAX(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.ok().build();
    }
}