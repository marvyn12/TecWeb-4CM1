package com.ejercicio8.ejercicio8.services;

import com.ejercicio8.ejercicio8.models.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoriaService {
    private final List<Categoria> categorias = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public CategoriaService() {
        guardarCategoria(new Categoria(null, "Deportes"));
        guardarCategoria(new Categoria(null, "Bebidas"));
        guardarCategoria(new Categoria(null, "Cultura"));
    }

    public void guardarCategoria(Categoria categoria) {
        categoria.setId(idCounter.getAndIncrement());
        categorias.add(categoria);
    }

    public List<Categoria> obtenerTodas() {
        return categorias;
    }

    public Categoria obtenerPorId(Long id) {
        return categorias.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public void actualizarCategoria(Categoria categoria) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId().equals(categoria.getId())) {
                categorias.set(i, categoria);
                break;
            }
        }
    }

    public void eliminarCategoria(Long id) {
        categorias.removeIf(c -> c.getId().equals(id));
    }
}