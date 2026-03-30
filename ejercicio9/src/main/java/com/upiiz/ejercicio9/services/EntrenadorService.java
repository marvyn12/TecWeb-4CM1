package com.upiiz.ejercicio9.services;

import com.upiiz.ejercicio9.entities.EntrenadorEntity;
import java.util.List;

public interface EntrenadorService {
    List<EntrenadorEntity> obtenerTodos();
    EntrenadorEntity obtenerPorId(Long id);
    void guardar(EntrenadorEntity entrenador);
    void eliminar(Long id);
}