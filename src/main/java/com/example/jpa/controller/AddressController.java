package com.example.jpa.controller;

import com.example.jpa.model.Address;
import com.example.jpa.repository.AddressRepository;
import com.example.jpa.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;
    @Autowired
    AddressRepository addressRepository;
    public AddressController(AddressService addressService){this.addressService = addressService;}

    @PostMapping()
    public ResponseEntity<Address> save(@RequestBody Address address) {
           address= addressService.addAddress(address);
        return new ResponseEntity<>(addressRepository.save(address), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List> list(){
        List<Address> list = AddressService.list(addressRepository);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping(value="{city}")
    public ResponseEntity<List> getAddressByCity(@PathVariable String city){
        List<Address> list = addressService.getAddressByCity(addressRepository,city);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @DeleteMapping(value="{id}")
    public  ResponseEntity<Address> delete(@PathVariable final Long id) {
        Address address = addressService.deleteAddress(id);
        return new ResponseEntity<>(address,HttpStatus.OK);
    }
}
