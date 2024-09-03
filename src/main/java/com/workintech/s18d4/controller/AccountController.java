package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.exceptions.AccountException;
import com.workintech.s18d4.exceptions.CustomerException;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;
    private CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }


    @GetMapping
    public List<Account> getAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable long id) {
        return accountService.find(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse postAccount(@PathVariable long customerId, @RequestBody Account account) {
        Customer customer = customerService.find(customerId);
        if(customer != null) {
            customer.getAccounts().add(account);
            account.setCustomer(customer);
            accountService.save(account);
        } else {
            throw new AccountException("asd", HttpStatus.BAD_REQUEST);
        }
        return new AccountResponse(account.getAccountName());
    }

    @PutMapping("/{customerId}")
    public AccountResponse putAccount(@PathVariable long customerId, @RequestBody Account account) {
        accountService.updateAccount(customerId, account);
        return new AccountResponse(account.getAccountName());
    }

    @DeleteMapping("/{id}")
    public AccountResponse deleteAccount(@PathVariable long id) {
        Account account = accountService.delete(id);
        return new AccountResponse(account.getAccountName());
    }

}
