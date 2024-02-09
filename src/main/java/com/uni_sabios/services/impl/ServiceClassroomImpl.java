package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.ClassroomNotFoundException;
import com.uni_sabios.repository.RepositoryClassroom;
import com.uni_sabios.repository.models.Classroom;
import com.uni_sabios.services.ServiceClassroom;

public class ServiceClassroomImpl implements ServiceClassroom{
    
    private final RepositoryClassroom crudRepositoryClassroom;
    
    public ServiceClassroomImpl(RepositoryClassroom crudRepositoryClassroom){
        this.crudRepositoryClassroom = crudRepositoryClassroom;
    }

    @Override
    public List<Classroom> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public Classroom getClassroom(String Code) throws ClassroomNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassroom'");
    }

    @Override
    public void create(Classroom classroom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void modify(Classroom classroom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public void delete(Classroom classroom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
