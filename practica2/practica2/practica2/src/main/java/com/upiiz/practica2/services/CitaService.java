package com.upiiz.practica2.services;

import com.upiiz.practica2.entities.Cita;
import com.upiiz.practica2.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;


    public List<Cita> obtenerTodas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerPorId(Long id) {
        return citaRepository.findById(id);
    }


    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }


    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }
}