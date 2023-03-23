package com.Goats.livestock48.service;

import com.Goats.livestock48.Livestock48Application;
import com.Goats.livestock48.model.Customer;
import com.Goats.livestock48.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public Customer getCustomerById(Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Customer with id " + id + " does not exist"));
        return customer;
    }

    public Customer addCustomer(Customer customer){
        repository.save(customer);
        return customer;
    }

    public Customer deleteCustomer(Long id){
        Customer customer = getCustomerById(id);
        repository.delete(customer);
        return customer;
    }

    @Transactional
    public Customer updateCustomerEmail(Long id, String email){
        Customer customer = getCustomerById(id);

        if(email != null
                && email.length() > 3
                && !Objects.equals(customer.getEmail(), email)
        ){
            customer.setEmail(email);
        }

        return customer;
    }

    public Customer getCustomerByEmail(String email){
        return repository.findCustomerByEmail(email)
                .orElseThrow(() -> new IllegalStateException("Customer with email" + email + " does not exist"));
    }

}
