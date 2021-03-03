package com.market.Ecommerceapp.application.controller;

import com.market.Ecommerceapp.domain.dal.ProductDAL;
import com.market.Ecommerceapp.domain.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductDAL> getAll() {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<ProductDAL> getOne(@PathVariable("id") int productId) {
        return productService.getOne(productId);
    }
    @GetMapping("/category/{id}")
    public Optional<List<ProductDAL>> getByCategory(@PathVariable("id") int categoryId) {
        return productService.getByCategory((categoryId));
    }
    @PostMapping()
    public ProductDAL create(@RequestBody ProductDAL product) {
        return productService.create(product);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int productId) {
        return productService.delete(productId);
    }
}
