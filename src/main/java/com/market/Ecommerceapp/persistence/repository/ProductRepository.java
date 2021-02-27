package com.market.Ecommerceapp.persistence.repository;

import com.market.Ecommerceapp.persistence.crud.ProductCrudRepository;
import com.market.Ecommerceapp.persistence.entity.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int categoryId) {
        return productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
    }

    public List<Product> getByStockAndStatus(int stock, boolean status) {
        Optional<List<Product>> result = productCrudRepository.findByStockLessThanAndStatus(stock, status);
        return result.orElse(Collections.emptyList());
    }

    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId);
    }

    public Product createProduct(Product product) {
        return productCrudRepository.save(product);
    }

    public void deleteProduct(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
