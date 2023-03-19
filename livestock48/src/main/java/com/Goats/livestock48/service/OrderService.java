package com.Goats.livestock48.service;

import com.Goats.livestock48.model.Order;
import com.Goats.livestock48.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAllOrders(){
        return repository.findAll();
    }

    public Order getOrderById(Long id){
        Order order = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order with id " + id + " does not exist."));
        return order;
    }

    public Order addOrder(Order order){
        repository.save(order);
        return order;
    }

    public Order deleteOrder(Long id){
        Order order = getOrderById(id);
        repository.delete(order);
        return order;
    }

    @Transactional
    public Order updateStatus(Long id, Boolean status){
        Order order = getOrderById(id);
        order.setStatus(status);
        return order;
    }
}
