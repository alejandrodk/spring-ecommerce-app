package com.market.Ecommerceapp.persistence.mapper;

import com.market.Ecommerceapp.domain.dal.PurchaseItemDAL;
import com.market.Ecommerceapp.persistence.entity.OrderProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemDalMapper {
    @Mappings({
            @Mapping(source = "status", target = "active")
    })
    PurchaseItemDAL toPurchaseItem(OrderProduct product);

    @InheritInverseConfiguration
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", ignore = true)
    OrderProduct toOrderProduct(PurchaseItemDAL purchaseItem);
}
