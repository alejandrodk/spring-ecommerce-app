package com.market.Ecommerceapp.persistence.mapper;

import com.market.Ecommerceapp.domain.dal.CategoryDAL;
import com.market.Ecommerceapp.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryDalMapper {
    @Mappings({
        @Mapping(source = "description", target = "category"),
        @Mapping(source = "status", target = "active")
    })
    CategoryDAL toCategoryDAL(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDAL categoryDAL);
}
