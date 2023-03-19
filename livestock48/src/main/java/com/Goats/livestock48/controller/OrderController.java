package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.Order;
import com.Goats.livestock48.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderController {

    private final OrderService service;
    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }

    @GetMapping(path = "{orderId}")
    public Order getOrderById(@PathVariable("orderId") Long orderId){
        return service.getOrderById(orderId);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        return service.addOrder(order);
    }

    @DeleteMapping(path = "{orderId}")
    public Order deleteOrder(@PathVariable("orderId") Long orderId){
        return service.deleteOrder(orderId);
    }

    @PutMapping(path = "{orderId}")
    public Order updateOrder(@PathVariable("orderId") Long orderId, @RequestParam(required = true) Boolean status){
        return service.updateStatus(orderId, status);
    }
}
