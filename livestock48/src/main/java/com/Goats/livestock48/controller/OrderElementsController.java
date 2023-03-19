package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.OrderElement;
import com.Goats.livestock48.service.OrderElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orderElements")
public class OrderElementsController {

    public final OrderElementService service;

    @Autowired
    public OrderElementsController(OrderElementService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderElement> getAllOrderElements(){
        return service.getAllOrderElements();
    }

    @GetMapping(path = "{orderElementId}")
    public OrderElement getOrderElementById(@PathVariable("orderElementId") Long orderElementId){
        return service.getOrderElementById(orderElementId);
    }

    @PostMapping
    public OrderElement addOrderElement(@RequestBody OrderElement orderElement){
        return service.addOrderElement(orderElement);
    }

    @DeleteMapping(path = "{orderElementId}")
    public OrderElement deleteOrderElement(@PathVariable("orderElementId") Long orderElementId){
        return service.deleteOrderElement(orderElementId);
    }

}
