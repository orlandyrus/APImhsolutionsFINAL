package com.example.mhsolutions.controller;

import com.example.mhsolutions.entity.Products;
import com.example.mhsolutions.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde el cliente Angular
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Products>> getAll() {
        List<Products> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

    // Obtener producto por ID
    @GetMapping("/{productId}")
    public ResponseEntity<Products> getById(@PathVariable("productId") Long productId) {
        Optional<Products> product = productsService.getProducts(productId);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products savedProduct = productsService.saveOrUpdate(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // Actualizar producto por ID
    @PutMapping("/{productId}")
    public ResponseEntity<Products> updateProduct(
            @PathVariable("productId") Long productId,
            @RequestBody Products product) {
        if (!productId.equals(product.getId())) {
            return ResponseEntity.badRequest().build();
        }

        // Verificar si el producto existe
        Optional<Products> existingProduct = productsService.getProducts(productId);
        if (existingProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Products updatedProduct = productsService.saveOrUpdate(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // Eliminar producto por ID
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
        if (!productsService.existsById(productId)) {
            return ResponseEntity.notFound().build();
        }
        productsService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}