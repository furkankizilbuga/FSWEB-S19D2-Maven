package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.AccountRepository;
import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.exceptions.AccountException;
import com.workintech.s18d4.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(long id) {
        return accountRepository.findById(id).orElseThrow(()
                -> new AccountException("An account with the given id could not be found!", HttpStatus.NOT_FOUND));
    }

    @Override
    public Account postAccount(long customerId, Account account) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()
                -> new CustomerException("A customer with given id could not be found!", HttpStatus.NOT_FOUND));
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    /*@Override
    public Account updateAccount(long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()
                -> new CustomerException("A customer with given id could not be found!", HttpStatus.NOT_FOUND));

    }*/

    @Override
    public Account deleteAccount(long id) {
        Account account = getById(id);
        accountRepository.delete(account);
        return account;
    }
}
