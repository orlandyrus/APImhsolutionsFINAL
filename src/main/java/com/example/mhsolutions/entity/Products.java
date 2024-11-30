package com.example.mhsolutions.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId; // Clave primaria

    private String productName;
    private String description;
    private Double price;
    private Integer stock;
    private String imageUrl;
    private Long categoryId;

    // Getter específico para productId
    public Long getId() {
        return productId;
    }
}