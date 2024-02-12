package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonException;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Student;

public interface ServiceStudent {
    List<Person> list();

    Person getPerson(String id) throws PersonException;

    void create(Student student);

    void modify(Student student);

    void delete(Student student);
}
