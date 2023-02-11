package com.example.jpa.service;


import com.example.jpa.model.Address;
import com.example.jpa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressrepository;

    public Address addAddress(Address address){
        return addressrepository.save(address);
    }

    public static List<Address> list(AddressRepository addressrepository) {
        return addressrepository.findAll();
    }
    public  Address getAddress(Long id){
        return addressrepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
    public  List<Address> getAddressByCity(AddressRepository addressRepository,String city){
        try{
            return addressRepository.findByCity(city);
        }
        catch(RuntimeException e){
            return null;
        }
    }
    public  Address deleteAddress(Long id){
        Address address = getAddress(id);
        addressrepository.delete(address);
        return address;
    }

}
