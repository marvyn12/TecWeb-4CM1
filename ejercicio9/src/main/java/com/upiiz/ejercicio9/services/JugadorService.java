<<<<<<< HEAD
package com.upiiz.ejercicio9.services;

import com.upiiz.ejercicio9.entities.JugadorEntity;
import java.util.List;

public interface JugadorService {
    List<JugadorEntity> obtenerTodos();
    JugadorEntity obtenerPorId(Long id);
    void guardar(JugadorEntity jugador);
    void eliminar(Long id);
=======
package com.upiiz.ejercicio9.services;

import com.upiiz.ejercicio9.entities.JugadorEntity;
import java.util.List;

public interface JugadorService {
    List<JugadorEntity> obtenerTodos();
    JugadorEntity obtenerPorId(Long id);
    void guardar(JugadorEntity jugador);
    void eliminar(Long id);
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
}