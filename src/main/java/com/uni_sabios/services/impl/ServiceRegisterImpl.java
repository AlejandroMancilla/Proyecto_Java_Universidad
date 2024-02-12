package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.registerexceptions.RegisterNullException;
import com.uni_sabios.repository.RepositoryRegister;
import com.uni_sabios.repository.models.Register;
import com.uni_sabios.services.ServiceRegister;

public class ServiceRegisterImpl implements ServiceRegister{

    private final RepositoryRegister crudRepositoryRegister;

    public ServiceRegisterImpl(RepositoryRegister crudRepositoryRegister) {
        this.crudRepositoryRegister = crudRepositoryRegister;
    }

    @Override
    public List<Register> list() {
        return this.crudRepositoryRegister.list();
    }

    @Override
    public Register getRegister(int registerId) throws RegisterNullException {
        Register register = this.crudRepositoryRegister.getRegister(registerId);
        if(register != null) {
            return register;
        }else {
            throw new RegisterNullException("No Register with this id was found");
        }
    }

    @Override
    public void create(Register register) {
        this.crudRepositoryRegister.create(register);
    }

    @Override
    public void modify(Register register) {
        this.crudRepositoryRegister.modify(register);
    }
    
}
