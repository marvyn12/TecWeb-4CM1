package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.Usuario;
import com.upiiz.examen2.repositories.UsuarioRepository;
import com.upiiz.examen2.services.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/";
        }
        model.addAttribute("error", "Credenciales invalidas");
        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(Usuario usuario, Model model) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            model.addAttribute("error", "El correo ya esta registrado");
            return "auth/register";
        }
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "auth/forgot-password";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email, Model model) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) {
            String password = usuario.getPassword();
            emailService.enviarCorreo(email, "Recuperacion de Password - Tienda Examen", "Tu password es: " + password);
            model.addAttribute("mensaje", "Password enviado a tu correo");
        } else {
            model.addAttribute("error", "Correo no encontrado");
        }
        return "auth/forgot-password";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}