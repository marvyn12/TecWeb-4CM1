package com.upiiz.ejercicio9.repositories;

import com.upiiz.ejercicio9.entities.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<JugadorEntity, Long> {
}