package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable long id) {
        return addressService.getById(id);
    }

    @PostMapping
    public Address postAddress(@RequestBody Address address) {
        return addressService.postAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable long id) {
        return addressService.updateAddress(id);
    }

    @DeleteMapping("/{id}")
    public Address deleteAddress(@PathVariable long id) {
        return addressService.deleteAddress(id);
    }

}
