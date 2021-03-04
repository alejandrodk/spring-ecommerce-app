package com.market.Ecommerceapp.domain.dal;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PurchaseDAL {
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItemDAL> item;
}
