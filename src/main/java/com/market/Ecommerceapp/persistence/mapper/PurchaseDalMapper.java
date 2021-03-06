package com.market.Ecommerceapp.persistence.mapper;

import com.market.Ecommerceapp.domain.dal.PurchaseDAL;
import com.market.Ecommerceapp.persistence.entity.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PurchaseItemDalMapper.class })
public interface PurchaseDalMapper {

    @Mappings({
            @Mapping(source = "orderId", target = "purchaseId"),
            @Mapping(source = "payment", target = "paymentMethod"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "products", target = "item"),
    })
    PurchaseDAL toPurchaseDAL(Order order);

    List<PurchaseDAL> toPurchasesDAL(List<Order> orders);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Order toOrder(PurchaseDAL purchase);

}
