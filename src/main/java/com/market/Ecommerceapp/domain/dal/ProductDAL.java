package com.market.Ecommerceapp.domain.dal;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDAL {
    private int productId;
    private String name;
    private int categoryId;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private CategoryDAL category;
}
