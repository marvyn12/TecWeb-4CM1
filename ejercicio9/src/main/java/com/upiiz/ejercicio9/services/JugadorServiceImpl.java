<<<<<<< HEAD
package com.upiiz.ejercicio9.services;

import com.upiiz.ejercicio9.entities.JugadorEntity;
import com.upiiz.ejercicio9.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public List<JugadorEntity> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    @Override
    public JugadorEntity obtenerPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(JugadorEntity jugador) {
        jugadorRepository.save(jugador);
    }

    @Override
    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }
=======
package com.upiiz.ejercicio9.services;

import com.upiiz.ejercicio9.entities.JugadorEntity;
import com.upiiz.ejercicio9.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public List<JugadorEntity> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    @Override
    public JugadorEntity obtenerPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(JugadorEntity jugador) {
        jugadorRepository.save(jugador);
    }

    @Override
    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }
>>>>>>> f80a6984cac4bc266da283b9d2a5c9f5b09c71d6
}