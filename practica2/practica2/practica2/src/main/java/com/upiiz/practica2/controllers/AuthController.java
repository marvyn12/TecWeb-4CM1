package com.upiiz.practica2.controllers;

import com.upiiz.practica2.entities.Usuario;
import com.upiiz.practica2.repositories.UsuarioRepository;
import com.upiiz.practica2.services.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/forgot-password")
    public String forgot() {
        return "forgot-password";
    }


    @PostMapping("/register")
    public String procesarRegistro(@ModelAttribute Usuario usuario, Model model) {


        Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente != null) {

            model.addAttribute("error", "Ese correo ya está registrado. Intenta iniciar sesión.");
            return "register";
        }


        usuarioRepository.save(usuario);
        return "redirect:/auth/login?exito";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                HttpSession session,
                                Model model) {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && usuario.getPassword().equals(password)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Credenciales inválidas. Intenta de nuevo.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }

    @PostMapping("/recover-password")
    public String procesarRecuperacion(@RequestParam("email") String email, Model model) {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {

            String asunto = "Recuperación de Contraseña - Gestión Clínica";
            String mensaje = "Hola " + usuario.getNombre() + ",\n\n"
                    + "Tu contraseña de acceso al sistema es: " + usuario.getPassword() + "\n\n"
                    + "Saludos,\nEquipo de UPIIZ.";

            emailService.enviarCorreo(usuario.getEmail(), asunto, mensaje);

            model.addAttribute("mensaje", "Contraseña enviada. Revisa tu bandeja de entrada (y la carpeta de Spam).");
        } else {
            model.addAttribute("error", "No se encontró ninguna cuenta con ese correo.");
        }

        return "forgot-password";
    }
}