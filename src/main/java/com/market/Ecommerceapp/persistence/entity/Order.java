package com.market.Ecommerceapp.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer orderId;

    @Column(name = "id_cliente")
    private String clientId;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago")
    private String payment;

    @Column(name = "comentario")
    private String comment;

    @Column(name = "estado")
    private String status;
}
