package com.market.Ecommerceapp.persistence.crud;

import com.market.Ecommerceapp.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {}
