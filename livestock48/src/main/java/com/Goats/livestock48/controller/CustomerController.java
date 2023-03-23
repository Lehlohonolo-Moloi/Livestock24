package com.Goats.livestock48.controller;

import com.Goats.livestock48.Livestock48Application;
import com.Goats.livestock48.model.Customer;
import com.Goats.livestock48.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService service;
    @Autowired
    private ViewController viewController;


    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("list_all_users")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping()
    public Customer getCustomerById(@RequestParam("customerId") Long customerId){
        return service.getCustomerById(customerId);
    }

    @PostMapping(value = "register")
    public ModelAndView addCustomer(@ModelAttribute Customer customer){
        service.addCustomer(customer);
        customer = getCustomerByEmail(customer.getEmail());
        Livestock48Application.setSelf(customer);
        return viewController.viewData();
    }

    @PostMapping(value = "login")
    public ModelAndView setCustomer(@ModelAttribute Customer customer){
        customer = getCustomerByEmail(customer.getEmail());
        Livestock48Application.setSelf(customer);
        return viewController.viewData();
    }

    @DeleteMapping(path = "{customerId}")
    public Customer deleteCustomer(@PathVariable("customerId") Long customerId){
        return service.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public Customer updateCustomerEmail(@PathVariable("customerId") Long customerId, @RequestParam(required = true, name = "email") String email){
        return service.updateCustomerEmail(customerId, email);
    }

    @GetMapping(path = "{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String email){
        return service.getCustomerByEmail(email);
    }

}
