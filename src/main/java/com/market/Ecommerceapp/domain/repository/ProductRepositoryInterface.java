package com.market.Ecommerceapp.domain.repository;

import com.market.Ecommerceapp.domain.dal.ProductDAL;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface {
    List<ProductDAL> getAll();
    Optional<List<ProductDAL>> getByCategory(int categoryId);
    Optional<List<ProductDAL>> getScaseProducts(int stockQuantity);
    Optional<ProductDAL> getProduct(int productId);
    ProductDAL create(ProductDAL product);
    void delete(int productId);
}
