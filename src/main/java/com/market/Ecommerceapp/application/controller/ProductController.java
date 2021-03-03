package com.market.Ecommerceapp.application.controller;

import com.market.Ecommerceapp.domain.dal.ProductDAL;
import com.market.Ecommerceapp.domain.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductDAL> getAll() {
        return productService.getAll();
    }

    public Optional<ProductDAL> getOne(int productId) {
        return productService.getOne(productId);
    }

    public Optional<List<ProductDAL>> getByCategory(int categoryId) {
        return productService.getByCategory((categoryId));
    }

    public ProductDAL create(ProductDAL product) {
        return productService.create(product);
    }

    public boolean delete(int productId) {
        return productService.delete(productId);
    }
}
