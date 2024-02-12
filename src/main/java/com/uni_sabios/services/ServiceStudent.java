package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.exceptions.personexceptions.PersonNullException;
import com.uni_sabios.exceptions.studentexceptions.StudentNullException;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Student;

public interface ServiceStudent {
    
    List<Person> list();  
    
    Person findByDocument(String document) throws PersonNullException;

    Student findbyId(int personId) throws StudentNullException;

    void create(Student student);

    void create(Person person, int idProgram) throws PersonExceptionInsertDataBase;

    void update(Student student);

    void delete(Student student) throws PersonNullException;

    void delete(String document) throws PersonNullException;

}