package com.example.mhsolutions.service;

import com.example.mhsolutions.entity.Products;
import com.example.mhsolutions.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    // Obtener todos los productos
    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

    // Obtener producto por ID
    public Optional<Products> getProducts(Long id) {
        return productsRepository.findById(id);
    }

    // Crear o actualizar un producto
    public Products saveOrUpdate(Products product) {
        return productsRepository.save(product);
    }

    // Eliminar producto por ID
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }

    // Verificar si el producto existe por ID
    public boolean existsById(Long id) {
        return productsRepository.existsById(id);
    }
}