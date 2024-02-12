package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.repository.models.Person;

public interface ServicePerson {
    
    List<Person> toList();

    Person findByDocument(String Document);

    void create(Person person) throws PersonExceptionInsertDataBase;

    void update(Person person);

    void delete(Person person);

}
