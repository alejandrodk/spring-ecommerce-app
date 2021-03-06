package com.market.Ecommerceapp.application.controller;

import com.market.Ecommerceapp.domain.dal.PurchaseDAL;
import com.market.Ecommerceapp.domain.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<PurchaseDAL>> getAll() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{client}")
    public ResponseEntity<List<PurchaseDAL>> getByClient(@PathVariable("client") String clientId) {
        return orderService.getByClient(clientId)
                .map(orders -> new ResponseEntity<>(orders, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping()
    public ResponseEntity<PurchaseDAL> create(@RequestBody PurchaseDAL purchase) {
        return new ResponseEntity<>(orderService.create(purchase), HttpStatus.CREATED);
    }
}
