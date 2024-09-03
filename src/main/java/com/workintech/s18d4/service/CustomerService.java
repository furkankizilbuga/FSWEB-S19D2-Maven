package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getById(long id);
    Customer postCustomer(Customer customer);
    Customer updateCustomer(long id);
    Customer deleteCustomer(long id);

}
