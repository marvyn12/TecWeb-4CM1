package com.upiiz.ejercicio9.services;

import com.upiiz.ejercicio9.entities.EntrenadorEntity;
import com.upiiz.ejercicio9.repositories.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public List<EntrenadorEntity> obtenerTodos() {
        return entrenadorRepository.findAll();
    }

    @Override
    public EntrenadorEntity obtenerPorId(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(EntrenadorEntity entrenador) {
        entrenadorRepository.save(entrenador);
    }

    @Override
    public void eliminar(Long id) {
        entrenadorRepository.deleteById(id);
    }
}