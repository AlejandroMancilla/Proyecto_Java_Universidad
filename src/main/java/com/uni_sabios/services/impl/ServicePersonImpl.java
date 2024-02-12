package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.repository.RepositoryPerson;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.services.ServicePerson;

public class ServicePersonImpl implements ServicePerson{

    private final RepositoryPerson crudRepositoryPerson;

    public ServicePersonImpl(RepositoryPerson crudRepositoryPerson) {
        this.crudRepositoryPerson = crudRepositoryPerson;
    }
    
    public List<Person> toList(){
        return crudRepositoryPerson.list();
    }

    public Person findByDocument(String Document) {
        return crudRepositoryPerson.getPerson(Document);
    }

    public void create(Person person) throws PersonExceptionInsertDataBase{
        crudRepositoryPerson.create(person);
    }

    public void update(Person person){
        crudRepositoryPerson.modify(person);
    }

    public void delete(Person person){
        crudRepositoryPerson.delete(person);
    }

}