package com.upiiz.tienda_mascotas.service;

import com.upiiz.tienda_mascotas.entity.Mascota;
import com.upiiz.tienda_mascotas.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> obtenerTodas() {
        return mascotaRepository.findAll();
    }

    public Mascota obtenerPorId(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }
}