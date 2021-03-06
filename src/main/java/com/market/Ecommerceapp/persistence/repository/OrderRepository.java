package com.market.Ecommerceapp.persistence.repository;

import com.market.Ecommerceapp.domain.dal.PurchaseDAL;
import com.market.Ecommerceapp.domain.repository.PurchaseRepositoryInterface;
import com.market.Ecommerceapp.persistence.crud.OrderCrudRepository;
import com.market.Ecommerceapp.persistence.entity.Order;
import com.market.Ecommerceapp.persistence.mapper.PurchaseDalMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements PurchaseRepositoryInterface {
    private OrderCrudRepository orderCrudRepository;
    private PurchaseDalMapper mapper;

    public OrderRepository(OrderCrudRepository orderCrudRepository, PurchaseDalMapper purchaseDalMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.mapper = purchaseDalMapper;
    }

    @Override
    public List<PurchaseDAL> getAll() {
        List<Order> orders = (List<Order>) orderCrudRepository.findAll();
        return mapper.toPurchasesDAL(orders);
    }

    @Override
    public Optional<List<PurchaseDAL>> getByClient(String clientId) {
        return orderCrudRepository.findByClientId(clientId)
                .map(orders -> mapper.toPurchasesDAL(orders));
    }

    @Override
    public PurchaseDAL create(PurchaseDAL purchase) {
        Order order = mapper.toOrder(purchase);
        order.getProducts().forEach(product -> product.setOrder(order));

        return mapper.toPurchaseDAL(orderCrudRepository.save(order));
    }
}
