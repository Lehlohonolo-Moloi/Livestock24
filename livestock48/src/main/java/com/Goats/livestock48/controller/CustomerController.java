package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.Customer;
import com.Goats.livestock48.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Long customerId){
        return service.getCustomerById(customerId);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public Customer deleteCustomer(@PathVariable("customerId") Long customerId){
        return service.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public Customer updateCustomerEmail(@PathVariable("customerId") Long customerId, @RequestParam(required = true, name = "email") String email){
        return service.updateCustomerEmail(customerId, email);
    }
}
