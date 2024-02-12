package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonException;
import com.uni_sabios.repository.RepositoryStudent;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Student;
import com.uni_sabios.services.ServiceStudent;



public class ServiceStudentImpl implements ServiceStudent{

    private final RepositoryStudent crudRepositoryStudent;

    public ServiceStudentImpl(RepositoryStudent crudRepositoryStudent) {
        this.crudRepositoryStudent = crudRepositoryStudent;
    }
    
    public List<Person> list(){
        return crudRepositoryStudent.list();
    }
    
    public Person getPerson(String document) throws PersonException {
        Person person = crudRepositoryStudent.getPerson(document);
        if(person == null){
            throw new PersonException("Person not found");
        } else {
            return person;
        }
    }

    public void create(Student student) {
        crudRepositoryStudent.create(student);
    }

    public void modify(Student student) {
        crudRepositoryStudent.modify(student);
    }

    public void delete(Student student) {
        crudRepositoryStudent.delete(student);
    }

}