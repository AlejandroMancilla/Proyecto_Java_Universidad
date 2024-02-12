package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonException;
import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.repository.RepositoryTeacher;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Teacher;
import com.uni_sabios.services.ServiceTeacher;

public class ServiceTeacherImpl implements ServiceTeacher{

    private final RepositoryTeacher crudRepositoryTeacher;
    
    public ServiceTeacherImpl(RepositoryTeacher crudRepositoryTeacher){
        this.crudRepositoryTeacher = crudRepositoryTeacher;
    }

    public List<Person> list(){
        return crudRepositoryTeacher.list();
    }

    public Person getPerson(String document) throws PersonException {
        Person person = crudRepositoryTeacher.getPerson(document);
        if(person == null){
            throw new PersonException("Person not found");
        } else {
            return person;
        }
    }

    public void create(Teacher teacher){
        crudRepositoryTeacher.create(teacher);
    }

    public void modify(Teacher teacher){
        crudRepositoryTeacher.modify(teacher);
    }

    public void delete(String document){
        crudRepositoryTeacher.delete(document);
    }

    @Override
    public void create(Person person, int departmentId) throws PersonExceptionInsertDataBase {
        crudRepositoryTeacher.create(person, departmentId);
    }
}
