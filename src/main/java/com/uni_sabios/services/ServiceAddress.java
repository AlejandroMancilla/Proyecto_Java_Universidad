package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.repository.models.Address;

public interface ServiceAddress {
    
    List<Address> list();

    Address getAddress(int addressId);

    void create(Address address);

    void modify(Address address);

    void delete(Address address);

}