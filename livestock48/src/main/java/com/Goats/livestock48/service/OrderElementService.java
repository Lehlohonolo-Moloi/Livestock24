package com.Goats.livestock48.service;

import com.Goats.livestock48.model.OrderElement;
import com.Goats.livestock48.repository.OrderElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderElementService {

    private final OrderElementRepository repository;
    @Autowired
    public OrderElementService(OrderElementRepository repository) {
        this.repository = repository;
    }

    public List<OrderElement> getAllOrderElements(){
        return repository.findAll();
    }

    public OrderElement getOrderElementById(Long id){
        OrderElement element = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("OrderElement with id" + id + " does not exist."));
        return element;
    }

    public OrderElement deleteOrderElement(Long id){
        OrderElement element = getOrderElementById(id);
        repository.delete(element);
        return element;
    }

    public OrderElement addOrderElement(OrderElement orderElement) {
        repository.save(orderElement);
        return orderElement;
    }
}
