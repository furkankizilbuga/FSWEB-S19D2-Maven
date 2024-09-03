package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Address;

import java.util.List;

public interface AccountService {

    List<Account> getAll();
    Account getById(long id);
    Account postAccount(long customerId, Account account);
    //Account updateAccount(long id);
    Account deleteAccount(long id);

}
