package com.market.Ecommerceapp.domain.repository;

import com.market.Ecommerceapp.domain.dal.PurchaseDAL;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryInterface {
    List<PurchaseDAL> getAll();
    Optional<List<PurchaseDAL>> getByClient(String clientId);
    PurchaseDAL create(PurchaseDAL purchase);
}
