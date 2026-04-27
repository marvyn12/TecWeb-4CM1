package com.upiiz.ejercicio9.services;

import com.upiiz.ejercicio9.entities.JugadorEntity;
import java.util.List;

public interface JugadorService {
    List<JugadorEntity> obtenerTodos();
    JugadorEntity obtenerPorId(Long id);
    void guardar(JugadorEntity jugador);
    void eliminar(Long id);
}