package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(long id) {
        return customerRepository.findById(id).orElseThrow(()
                -> new CustomerException("A customer with the given id could not be found!", HttpStatus.NOT_FOUND));
    }

    @Override
    public Customer postCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(long id) {
        Customer customer = getById(id);
        return postCustomer(customer);
    }

    @Override
    public Customer deleteCustomer(long id) {
        Customer customer = getById(id);
        customerRepository.delete(customer);
        return customer;
    }

}
