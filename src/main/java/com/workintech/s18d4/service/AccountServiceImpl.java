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

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    /*@Override
    public Account updateAccount(Customer customer) {

        Account tobeUpdated = null;

        for(Account account : customer.getAccounts()) {
            if(account.getId() == newAccount.getId()) {
                tobeUpdated = account;
            }
        }

        if(tobeUpdated == null) {
            throw new AccountException("Account could not be found!", HttpStatus.NOT_FOUND);
        }

        int indexTobeUpdated = customer.getAccounts().indexOf(tobeUpdated);
        customer.getAccounts().set(indexTobeUpdated, newAccount);
        newAccount.setCustomer(customer);
        accountRepository.save(newAccount);
        return newAccount;
    }*/

    @Override
    public Account delete(long id) {
        Account account = find(id);
        accountRepository.delete(account);
        return account;
    }
}
