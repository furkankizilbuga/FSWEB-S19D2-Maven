package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.AddressRepository;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.exceptions.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(long id) {
        return addressRepository.findById(id).orElseThrow(()
                -> new AddressException("An address with given id could not be found!", HttpStatus.NOT_FOUND));
    }

    @Override
    public Address postAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(long id) {
        Address address = getById(id);
        return address;
    }

    @Override
    public Address deleteAddress(long id) {
        Address address = getById(id);
        addressRepository.delete(address);
        return address;
    }

}
