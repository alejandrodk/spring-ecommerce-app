package com.market.Ecommerceapp.domain.service;

import com.market.Ecommerceapp.domain.dal.PurchaseDAL;
import com.market.Ecommerceapp.domain.repository.PurchaseRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final PurchaseRepositoryInterface purchaseRepository;

    public OrderService(PurchaseRepositoryInterface purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<PurchaseDAL> getAll() {
        return this.purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDAL>> getByClient(String clientId) {
        return this.purchaseRepository.getByClient(clientId);
    }

    public PurchaseDAL create(PurchaseDAL purchaseDAL) {
        return this.purchaseRepository.create(purchaseDAL);
    }
}
