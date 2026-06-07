package com.upiiz.ajax.services;

import com.upiiz.ajax.entities.CategoriaEntity;
import com.upiiz.ajax.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> listado() {
        return categoriaRepository.findAll();
    }
}