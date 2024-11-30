package com.example.mhsolutions.repository;

import com.example.mhsolutions.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}