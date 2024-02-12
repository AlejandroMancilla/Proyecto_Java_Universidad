package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Person;

public interface RepositoryPerson {

    List<Person> list();

    Person getPerson(String document);

    void create(Person person);

    void modify(Person person);

    void delete(Person person);
    
}
