package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Address;

public interface RepositoryAddress {
        
    List<Address> list();

    Address getAddress(int addressId);

    void create(Address address);

    void modify(Address address);

    void delete(Address address);

}