package com.market.Ecommerceapp.persistence.mapper;

import com.market.Ecommerceapp.domain.dal.ProductDAL;
import com.market.Ecommerceapp.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryDalMapper.class })
public interface ProductDalMapper {
    @Mappings({
        @Mapping(source = "sellPrice", target = "price"),
        @Mapping(source = "status", target = "active")
    })
    ProductDAL toProductDal(Product product);

    List<ProductDAL> toProductsDal(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(ProductDAL productDAL);
}
