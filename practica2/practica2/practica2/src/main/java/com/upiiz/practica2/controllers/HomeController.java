package com.upiiz.practica2.controllers;

import com.upiiz.practica2.entities.Cita;
import com.upiiz.practica2.repositories.CitaRepository;
import com.upiiz.practica2.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private CitaRepository citaRepository;

    @GetMapping("/")
    public String dashboard(Model model) {

        long totalPacientesReales = pacienteRepository.count();
        long totalCitasReales = citaRepository.count();

        model.addAttribute("totalPacientes", totalPacientesReales);
        model.addAttribute("totalCitas", totalCitasReales);
        model.addAttribute("citasHoy", 0);


        List<Cita> todasLasCitas = citaRepository.findAll();


        Map<String, Long> conteoEspecialidades = todasLasCitas.stream()
                .collect(Collectors.groupingBy(
                        Cita::getEspecialidad,
                        Collectors.counting()
                ));


        model.addAttribute("labelsGrafica", conteoEspecialidades.keySet());
        model.addAttribute("datosGrafica", conteoEspecialidades.values());


        model.addAttribute("especialidades", conteoEspecialidades.size());

        return "home/index";
    }
}