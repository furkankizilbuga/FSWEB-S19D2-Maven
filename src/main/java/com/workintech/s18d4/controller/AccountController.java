package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable long id) {
        return accountService.getById(id);
    }

    @PostMapping("/{customerId}")
    public Account postAccount(@PathVariable long customerId, @RequestBody Account account) {
        return accountService.postAccount(customerId, account);
    }

    /*@PutMapping("/{customerId}")
    public Account putAccount(@PathVariable long customerId, @RequestBody Account account) {
        return accountService.updateAccount
    }*/

    @DeleteMapping("/{id}")
    public Account deleteAccount(@PathVariable long id) {
        return accountService.deleteAccount(id);
    }

}
