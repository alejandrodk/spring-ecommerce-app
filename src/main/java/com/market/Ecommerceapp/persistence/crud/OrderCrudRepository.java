package com.market.Ecommerceapp.persistence.crud;

import com.market.Ecommerceapp.persistence.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderCrudRepository extends CrudRepository <Order, Integer> {
    Optional<List<Order>> findByClientId(String clientId);
}
