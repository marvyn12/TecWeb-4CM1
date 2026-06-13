package com.upiiz.tienda_mascotas.controller;

import com.upiiz.tienda_mascotas.entity.Mascota;
import com.upiiz.tienda_mascotas.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<Mascota> listar() {
        return mascotaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Mascota obtenerUna(@PathVariable Long id) {
        return mascotaService.obtenerPorId(id);
    }

    @PostMapping
    public Mascota crear(@RequestBody Mascota mascota) {
        return mascotaService.guardar(mascota);
    }

    @PutMapping("/{id}")
    public Mascota actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        mascota.setId(id);
        return mascotaService.guardar(mascota);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
    }
}