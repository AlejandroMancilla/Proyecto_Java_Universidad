package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Student;

public interface RepositoryStudent {

    List<Person> list();
    
    Person getPerson(String document);

    void create(Student student);

    void modify(Student student);

    void delete(Student student);

}