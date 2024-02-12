package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.studentexceptions.StudentNullException;
import com.uni_sabios.repository.RepositoryStudent;
import com.uni_sabios.repository.models.Student;
import com.uni_sabios.services.ServiceStudent;

public class ServiceStudentImpl implements ServiceStudent{

    private final RepositoryStudent crudRepositoryStudent;
    
    public ServiceStudentImpl(RepositoryStudent crudRepositoryStudent){
        this.crudRepositoryStudent = crudRepositoryStudent;
    }

    @Override
    public List<Student> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public void create(Student Student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void modify(Student Student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public void delete(Student Student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Student getStudent(String id) throws StudentNullException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudent'");
    }
}
