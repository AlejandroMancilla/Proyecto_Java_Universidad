package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.exceptions.personexceptions.PersonNullException;
import com.uni_sabios.repository.models.Person;

public interface ServicePerson {
    
    List<Person> toList();

    Person findByDocument(String Document) throws PersonNullException;

    Person findById(int id) throws PersonNullException;

    void create(Person person) throws PersonExceptionInsertDataBase;

    void update(Person person);

    void delete(Person person);

}
