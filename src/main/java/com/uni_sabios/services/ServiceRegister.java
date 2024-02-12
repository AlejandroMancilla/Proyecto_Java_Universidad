package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.registerexceptions.RegisterNullException;
import com.uni_sabios.repository.models.Register;

public interface ServiceRegister {
    
    List<Register> list();

    Register getRegister(int registerId) throws RegisterNullException;

    void create(Register register);

    void modify(Register register);

}
