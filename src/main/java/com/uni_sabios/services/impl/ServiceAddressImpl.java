package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.repository.RepositoryAddress;
import com.uni_sabios.repository.models.Address;
import com.uni_sabios.services.ServiceAddress;

public class ServiceAddressImpl implements ServiceAddress {

    private final RepositoryAddress crudRepositoryAddress;

    public ServiceAddressImpl(RepositoryAddress crudRepositoryAddress) {
        this.crudRepositoryAddress = crudRepositoryAddress;
    }
    
    @Override
    public List<Address> list() {
        return this.crudRepositoryAddress.list();
    };

    public Address getAddress(int address_id) {
        return this.crudRepositoryAddress.getAddress(address_id);
    }

    public void create(Address address) {
        this.crudRepositoryAddress.create(address);
    }

    public void modify(Address address){
        this.crudRepositoryAddress.modify(address);
    }

    public void delete(Address address){
        this.crudRepositoryAddress.delete(address);
    }

}
