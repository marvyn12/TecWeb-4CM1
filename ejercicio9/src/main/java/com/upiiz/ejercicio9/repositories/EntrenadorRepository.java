package com.upiiz.ejercicio9.repositories;

import com.upiiz.ejercicio9.entities.EntrenadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<EntrenadorEntity, Long> {
}