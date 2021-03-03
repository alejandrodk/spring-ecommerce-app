package com.market.Ecommerceapp.domain.service;

import com.market.Ecommerceapp.domain.dal.ProductDAL;
import com.market.Ecommerceapp.domain.repository.ProductRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepositoryInterface productRepository;

    public ProductService(ProductRepositoryInterface productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDAL> getAll() {
        return this.productRepository.getAll();
    }

    public Optional<ProductDAL> getOne(int productId) {
        return this.productRepository.getProduct(productId);
    }

    public Optional<List<ProductDAL>> getByCategory(int categoryId) {
        return this.productRepository.getByCategory(categoryId);
    }

    public ProductDAL create(ProductDAL product) {
        return this.productRepository.create(product);
    }

    public boolean delete(int productId) {
        return getOne(productId).map(product -> {
            this.productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
