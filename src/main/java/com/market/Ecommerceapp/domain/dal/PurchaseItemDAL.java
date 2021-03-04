package com.market.Ecommerceapp.domain.dal;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseItemDAL {
    private int productId;
    private int quantity;
    private BigDecimal total;
    private boolean active;
}
