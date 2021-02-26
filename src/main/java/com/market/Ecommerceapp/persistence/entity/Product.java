package com.market.Ecommerceapp.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer productId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    private Integer categoryId;

    @Column(name = "codigo_barras")
    private String barcode;

    @Column(name = "precio_venta")
    private Double sellPrice;

    @Column(name = "cantidad_stock")
    private Integer stock;

    @Column(name = "estado")
    private Boolean status;
}
