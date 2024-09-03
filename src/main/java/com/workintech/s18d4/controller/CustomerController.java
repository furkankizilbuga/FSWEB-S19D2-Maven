package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.postCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable long id) {
        return customerService.updateCustomer(id);
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable long id) {
        return customerService.deleteCustomer(id);
    }
}
