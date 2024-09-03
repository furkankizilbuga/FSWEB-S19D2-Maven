package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();
    Address getById(long id);
    Address postAddress(Address address);
    Address updateAddress(long id);
    Address deleteAddress(long id);
}
