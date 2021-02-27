package com.market.Ecommerceapp.persistence.repository;

import com.market.Ecommerceapp.persistence.crud.ProductCrudRepository;
import com.market.Ecommerceapp.persistence.entity.Product;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }
}
