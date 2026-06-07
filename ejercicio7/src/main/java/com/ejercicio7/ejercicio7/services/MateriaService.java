package com.ejercicio7.ejercicio7.services;

import com.ejercicio7.ejercicio7.models.Materia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MateriaService {

    private final List<Materia> materias = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public void guardarMateria(Materia materia) {
        materia.setId(idCounter.getAndIncrement());
        materias.add(materia);
    }

    public List<Materia> obtenerTodas() {
        return materias;
    }

    public Materia obtenerPorId(Long id) {
        return materias.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void actualizarMateria(Materia materiaActualizada) {
        for (int i = 0; i < materias.size(); i++) {
            Materia m = materias.get(i);
            if (m.getId().equals(materiaActualizada.getId())) {
                materias.set(i, materiaActualizada);
                break;
            }
        }
    }

    public void eliminarMateria(Long id) {
        materias.removeIf(m -> m.getId().equals(id));
    }
}