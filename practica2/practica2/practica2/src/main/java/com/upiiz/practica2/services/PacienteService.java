package com.upiiz.practica2.services;

import com.upiiz.practica2.entities.Paciente;
import com.upiiz.practica2.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }


    public Optional<Paciente> obtenerPorId(Long id) {
        return pacienteRepository.findById(id);
    }


    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }


    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}