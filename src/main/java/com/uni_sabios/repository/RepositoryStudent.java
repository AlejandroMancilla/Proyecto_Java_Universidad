package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Student;

public interface RepositoryStudent {
    
    List<Person> toList();
    
    Person findByDocument(String document);

    void create(Student student);

    void create(Person person, int idProgram) throws PersonExceptionInsertDataBase;

    void modify(Student student);

    void delete(Student student);

    void delete(String document);

}