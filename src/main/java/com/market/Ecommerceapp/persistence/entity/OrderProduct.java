package com.market.Ecommerceapp.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_compra")
    private Integer orderId;

    @Column(name = "id_producto")
    private Integer productId;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "estado")
    private String status;

    private BigDecimal total;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;
}
