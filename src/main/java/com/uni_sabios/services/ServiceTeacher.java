package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonException;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Teacher;

public interface ServiceTeacher {
    
    List<Person> list();

    Person getPerson(String document) throws PersonException;

    void create(Teacher teacher);

    void modify(Teacher teacher);

    void delete(Teacher teacher);

}
