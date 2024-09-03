package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
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
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable long id) {
        return customerService.find(id);
    }

    @PostMapping
    public CustomerResponse postCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary());
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable long id) {
        return customerService.updateCustomer(id);
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable long id) {
        return customerService.delete(id);
    }
}
