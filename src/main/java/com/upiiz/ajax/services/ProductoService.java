package com.upiiz.ajax.services;

import com.upiiz.ajax.entities.ProductoEntity;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<ProductoEntity> listado();
    Optional<ProductoEntity> productoPorId(Long id);
    ProductoEntity agregarProducto(ProductoEntity producto);
    ProductoEntity actualizarProducto(Long id, ProductoEntity producto);
    void eliminarProducto(Long id);
}