package com.ejercicio8.ejercicio8.services;

import com.ejercicio8.ejercicio8.models.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ProductoService() {
        guardarProducto(new Producto(null, "Raqueta", 450.00, "Deportes"));
        guardarProducto(new Producto(null, "Coca-Cola", 25.00, "Bebidas"));
    }

    public void guardarProducto(Producto producto) {
        producto.setId(idCounter.getAndIncrement());
        productos.add(producto);
    }

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public Producto obtenerPorId(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public void actualizarProducto(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(producto.getId())) {
                productos.set(i, producto);
                break;
            }
        }
    }

    public void eliminarProducto(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}