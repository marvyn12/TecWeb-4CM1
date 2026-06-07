package com.upiiz.practica2.repositories;

import com.upiiz.practica2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Magia de Spring Data: Esto nos crea la consulta SQL en automático
    Usuario findByEmail(String email);
}