package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.Animal;
import com.Goats.livestock48.model.Customer;
import com.Goats.livestock48.model.Purchase;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/Animal")
    public ModelAndView viewData() {
        List<Animal> dataList = restTemplate.getForObject("http://localhost:8080/api/v1/animals/list_animals", List.class);
        ModelAndView model = new ModelAndView("Animal");

        model.addObject("Animal",dataList);
        return model;
    }

    @GetMapping("/Users")
    public ModelAndView viewUsers() {
        List<Customer> dataList = restTemplate.getForObject("http://localhost:8080/api/v1/customers/list_all_users", List.class);
        ModelAndView model = new ModelAndView("Users");

        model.addObject("Customer",dataList);
        return model;
    }

    @GetMapping("/Orders")
    public ModelAndView viewOrdersElement() {
        List<Purchase> dataList = restTemplate.getForObject("http://localhost:8080/api/v1/purchaseElements/list_purchases", List.class);
        ModelAndView model = new ModelAndView("Orders");

        model.addObject("Purchase",dataList);
        return model;
    }

    @GetMapping()
    public ModelAndView searchById(@RequestParam("customerId") Long customerId) {
        List<Customer> dataList = restTemplate.getForObject("http://localhost:8080/api/v1/customers/" , List.class);
        ModelAndView model = new ModelAndView("Search");

        model.addObject("Customers",dataList);
        return model;
    }

    @GetMapping("/Registration")
    public String viewRegistration(Model model) {
        model.addAttribute("customer", new Customer());
        return "Registration";
    }

}
